package fr.serfa.lpdaoo25.jeucarte.model;


import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;

public class Game {

    private final static int WON_CARD_SCORE = 40;
    private final static int ERROR_PENALTY = -10;
    private final static int ERROR_OBVIOUS_PENALTY = -20;
    private Instant start_time = Instant.now(); //https://stackoverflow.com/a/75493748
    private Instant end_time = null;



    private Long id;

    private String name;

    private boolean isOver = false;

    private int error = 0;
    private int errorObvious = 0;

    private final int CARDS_NUMBER;

    private Stack<Card> draw = new Stack<>();

    private Stack<Card> discardCards = new Stack<>();

    public String getName() {
        return name;
    }

    public Game(String name) {
        this.CARDS_NUMBER = 0;
        this.name = name;
    }
    public Game(String name, Set<Card> cards) {
        this.draw = cards.stream().collect(Stack::new, Stack::push, Stack::addAll);
        this.initGame();
        this.CARDS_NUMBER = cards.size();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public long getGameDuration() {
        Instant clock;
        if (this.isOver)
            clock = this.end_time;
        else
            clock = Instant.now();
        return  Duration.between(this.start_time, clock).toSeconds();
    }
    public int getError() {
        return error;
    }

    public int getErrorObvious() {
        return errorObvious;
    }

    public void addError() {
        this.error++;
    }

    public void addErrorObvious() {
        this.errorObvious++;
    }

    public List<Card> getDraw() {
        return draw;
    }

    public int getDiscardCardsNumber() {
        return discardCards.size();
    }

    public int getNumberRemainingCards() {
        return draw.size();
    }

    public int getCardsNumber() {
        return this.CARDS_NUMBER;
    }

    public boolean isOver() {
        return this.isOver;
    }

    /**
     * Return the hand card.
     * It is the card at the top of the draw stack
     * this does not remove the card from the stack
     * the hand is always the first card of the draw stack
     */
    public Card getHandCard() {
        if(this.isOver)
            return null;
        return draw.peek();
    }

    public Card getReferenceCard() {
        if(this.isOver)
            return null;
        return discardCards.peek();
    }

    public PlayResult play(Long playedShapeID) {
        if(this.isOver) {
            return new PlayResult(PlayResult.PlayStatus.GAME_OVER, null);
        }
        Shape played = this.getHandCard().getShapeById(playedShapeID);
        if(played == null)
            return new PlayResult(PlayResult.PlayStatus.CHEAT, null);
        if(isCheatMove(played)){
                /** //todo : handle exception in controller
                 * // for now we will return an erroneous PlayResult with a big penalty assuming the player cheated
                 throw new RuntimeException("The played shape is not in the hand card it should never happend \n" +
                 "hand card : " + handCard + "\n" +
                 "Played shape : " + played);
                 //*/
            return new PlayResult(PlayResult.PlayStatus.CHEAT, null);
        }
        if (isValidMove(played)) {
            Card newHand = this.winCard();
            if (newHand == null)
                return new PlayResult(PlayResult.PlayStatus.GAME_OVER, null);
            else
                return new PlayResult(PlayResult.PlayStatus.OK, newHand);
        } else {
            return this.handleError(played);
        }
    }

    public boolean isCheatMove(Shape played){
        return !getHandCard().contains(played);
    };

    //TODO : will be enhanced once cards will be attached by shapes graph
    public boolean isValidMove(Shape played) {
        Card referenceCard = getReferenceCard();
        return referenceCard.contains(played);
    }

    /**
     * Play the card at the top of the draw stack
     * @return the new hand card
     */
    private Card winCard() {
        if(this.isOver)
            return null;

        discardCards.push(draw.pop());
        if (draw.size() == 0) {
            this.isOver = true;
            this.end_time = Instant.now();
            return null;
        }
        return getHandCard();
    }

    //todo : could be extracted to a service
    public Shape getMatchingShape() {
        Card handCard = getHandCard();
        Card referenceCard = getReferenceCard();
        // find the only matching shape in both cards
        for (Shape s : handCard.getShapes()){
            if(referenceCard.contains(s)){
                return s;
            }
        }
        throw new RuntimeException("No matching shape found in both cards\n" +
                "hand card : " + handCard + "\n" +
                "Reference card : " + referenceCard);
    }

    //todo : could be extracted to a service
    public PlayResult handleError(Shape played) {
        Shape winningShape = getMatchingShape();
        if(played.getType() != winningShape.getType()){
            this.errorObvious++;
            return new PlayResult(PlayResult.PlayStatus.ERROR_OBVIOUS, null);
        } else if(played.getColor() != winningShape.getColor()){
            this.error++;
            return new PlayResult(PlayResult.PlayStatus.ERROR, null);
        }
        throw new RuntimeException("In error handling : The played shape is the one matching between the cards. It should never happend because handled previously\n" +
                "matchingShape card : " + winningShape + "\n" +
                "Played shape : " + played);
    }

    public int getfinalScore() {
        if(!this.isOver){
            return -1;
        }
        int score = this.discardCards.size()*WON_CARD_SCORE
                + this.error *ERROR_PENALTY
                + this.errorObvious *ERROR_OBVIOUS_PENALTY
                - (int) this.getGameDuration();
        if (score<0){
            return 0;
        }
        return score;
    }

    //todo : could be extracted to a service
    public void initGame() {
        //shuffle randomly the cards
        List<Card> cards = new ArrayList<>(this.draw);

        // Shuffle the list.
        Collections.shuffle(cards);

        // Convert the shuffled list back to a stack.
        draw.clear();
        for (Card c : cards) {
            draw.push(c);
        }

        //place the first card on the discard stack as a reference card
        this.winCard();
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", error=" + error +
                ", errorObvious=" + errorObvious +
                ", NUMBER_CARDS=" + CARDS_NUMBER +
                ", drawNumber=" + draw.size() +
                ", discardNumber=" + discardCards.size() +
                ", draw=" + draw +
                ", discardCards=" + discardCards +
                '}';
    }


}
