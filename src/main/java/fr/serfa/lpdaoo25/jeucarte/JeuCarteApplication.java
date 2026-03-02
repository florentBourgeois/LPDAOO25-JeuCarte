package fr.serfa.lpdaoo25.jeucarte;

import fr.serfa.lpdaoo25.jeucarte.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class JeuCarteApplication {

    public static void main(String[] args) {
        SpringApplication.run(JeuCarteApplication.class, args);
    }



    @Bean
    CommandLineRunner initRepos() {
        return args -> {



            Shape squareRed = new Rectangle(10, 10, Shape.ShapeColor.RED);
            squareRed.setId(0L);
            Shape rectangleBlue = new Rectangle(5, 20, Shape.ShapeColor.BLUE);
            rectangleBlue.setId(1L);
            Shape triangleGreen = new Rectangle(10, 10, Shape.ShapeColor.GREEN);
            triangleGreen.setId(2L);

            Card cEasyGame1 = new Card(Set.of(squareRed));
            cEasyGame1.setId(0L);
            Card cEasyGame2 = new Card(Set.of(squareRed));
            cEasyGame2.setId(1L);

            Card c1 = new Card(Set.of(squareRed, rectangleBlue));
            c1.setId(2L);
            Card c2 = new Card(Set.of(squareRed, triangleGreen));
            c2.setId(3L);
            Card c3 = new Card(Set.of(rectangleBlue, triangleGreen));
            c3.setId(4L);




            // add some other games
            Game easyGameOneCard  = new Game("easy Game One Card", Set.of(cEasyGame1));
            Game easyGame2OneCard  = new Game("easy game 2 one card", Set.of(cEasyGame2));
            Game gameTwoCards  = new Game("easy game 2 cards", Set.of(cEasyGame1, cEasyGame2));
            Game gameThreeCards  = new Game("again game 3 cards", Set.of(c1, c2, c3));

            Game g = easyGameOneCard;
            System.out.println(g.play(squareRed.getId()));
            System.out.println(g.play(squareRed.getId()));
            System.out.println("game is over ? " + g.isOver() + " and the score is " + g.getfinalScore());

            System.out.println(g.play(squareRed.getId()));
            System.out.println(g);
            System.out.println("game is over ? " + g.isOver() + " and the score is " + g.getfinalScore());


            System.out.println(g.play(rectangleBlue.getId()));
            System.out.println(g);
            System.out.println("game is over ? " + g.isOver() + " and the score is " + g.getfinalScore());


            System.out.println(g.play(triangleGreen.getId()));
            System.out.println(g);
            System.out.println("game is over ? " + g.isOver() + " and the score is " + g.getfinalScore());

        };
    }

}
