import {GameForList} from "./gameForList";
import {Card} from "./card";



export interface Game extends GameForList {
  isOver : boolean;
  score : number;
  gameDuration : number;
  cardsNumber : number;
  numberWonCard : number;
  referenceCard : Card;
  hand : Card;

}
