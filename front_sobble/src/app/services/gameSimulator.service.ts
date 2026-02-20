import {Injectable} from '@angular/core';
import {GameForList} from "../models/gameForList";
import {Game} from "../models/game";
import {HelpFactory} from "../models/helpFactory";
import {PlayResult} from "../models/playResult";
import {PlayStatusEnum} from "../models/playStatus";
import {GameServiceInterface} from "./game.service.interface";

@Injectable({
  providedIn: 'root'
})
export class GameSimulatorService implements GameServiceInterface{

  constructor() { }


  getAllGames(): Promise<GameForList[]> {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        resolve([{id:1, name:"Sobble"}, {id:2, name:"Grookey"}, {id:3, name:"Scorbunny"}, {id:4, name:"Squirtle"}, {id:5, name:"Charmander"}, {id:6, name:"Bulbasaur"}]);
      }, 1000);
    });
  }

  //TODO: remove this method which is useless for real API
  createGame(numberOfShapesPerCard: number): Promise<Game> {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        let game :Game;
        let randomNumber = Math.floor(Math.random() * 10);
        if (randomNumber == 0) {
          game = HelpFactory.createGameOver();
        }
        else {
          game = HelpFactory.createGame1();
        }
        resolve(game);
      }, 1000);
    });
  }


  //TODO: remove this method which is useless for real API
  getGame(id:number): Promise<Game> {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        let game :Game;
        let randomNumber = Math.floor(Math.random() * 10);
        if (randomNumber == 0) {
          game = HelpFactory.createGameOver();
        }
        else {
          game = HelpFactory.createGame1();
        }
        game.id = id;

        resolve(game);
      }, 1000);
    });
  }


  //TODO: remove this method which is useless for real API
  play(gameId:number, shapeId: number): Promise<PlayResult > {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        let playStatus :PlayStatusEnum = Math.floor(Math.random() * 4);
        //playStatus = PlayStatusEnum.GAME_OVER; // to test specific status
        let scoreValue : number = Math.floor(Math.random() * 100);
        let newHand = HelpFactory.createCardRandom();
        let playResult :PlayResult = { playStatus: { name: playStatus, scoreValue: scoreValue}, newHand: newHand};
        resolve(playResult);
      }, 1000);
    });
  }

}
