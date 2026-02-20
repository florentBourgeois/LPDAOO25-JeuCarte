import { Card } from '../models/card';
import { Shape } from '../models/shape';
import {Game} from "./game";

export class HelpFactory {


  static createCard1(): Card {
    return {
      id: 1,
      shapes: [
        { id: 1, color: 'red', type: 'circle' },
        { id: 2, color: 'blue', type: 'rectangle' },
        { id: 4, color: 'green', type: 'rectangle' },
        { id: 5, color: 'purple', type: 'triangle' },
        { id: 6, color: 'green', type: 'triangle' },
        { id: 7, color: 'blue', type: 'circle' },
        { id: 7, color: 'blue', type: 'circle' },
        { id: 7, color: 'blue', type: 'circle' },
        { id: 7, color: 'blue', type: 'circle' }
      ]
    };
  }


  static createCard2(): Card {
    return {
      id: 2,
      shapes: [
        { id: 3, color: 'red', type: 'triangle' },
        { id: 2, color: 'blue', type: 'rectangle' }
      ]
    };
  }

  static createCardRandom(): Card {
    let nbrShapes = Math.floor(Math.random() * 9);
    let shapes : Shape[] = [];
    for (let i = 0; i < nbrShapes; i++) {
        shapes.push(HelpFactory.createShapeRandom());
    }
    return {
      id: Math.floor(Math.random() * 1000),
      shapes:shapes
    };
  }

  static createShapeRandom(): Shape {
    const shapes = ['circle', 'rectangle', 'triangle', 'square'];
    const colors = ['red', 'blue', 'green', 'purple', 'yellow', 'orange', 'black', 'pink', 'cyan', 'violet'];

    const randomShape = shapes[Math.floor(Math.random() * shapes.length)];
    const randomColor = colors[Math.floor(Math.random() * colors.length)];

    return {
      id: Math.floor(Math.random() * 1000), // Generate a random id
      color: randomColor,
      type: randomShape
    };
  }

  static createGame1(): Game {
    return {
      id: 1,
      name: 'Sobble',
      isOver: false,
      score: 0,
      gameDuration: 0,
      cardsNumber: 2,
      numberWonCard: 0,
      referenceCard: HelpFactory.createCard1(),
      hand: HelpFactory.createCard2()
    };
  }


  static createGameOver(): Game {
    return {
      id: 1,
      name: 'EndGame',
      isOver: true,
      score: 100,
      gameDuration: 5,
      cardsNumber: 20,
      numberWonCard: 20,
      referenceCard: HelpFactory.createCard1(),
      hand: HelpFactory.createCard2()
    };
  }
}
