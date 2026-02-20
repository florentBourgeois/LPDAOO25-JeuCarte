import {GameForList} from "../models/gameForList";
import {Game} from "../models/game";
import {HelpFactory} from "../models/helpFactory";
import {PlayResult} from "../models/playResult";
import {PlayStatusEnum} from "../models/playStatus";
import {InjectionToken} from "@angular/core";

export const GAME_SERVICE_TOKEN = new InjectionToken<GameServiceInterface>('GameServiceInterface');

export interface GameServiceInterface {

  getAllGames(): Promise<GameForList[]>;
  createGame(numberOfShapesPerCard:number): Promise<Game>;
  getGame(id:number): Promise<Game>;
  play(gameId:number, shapeId: number): Promise<PlayResult >;
}
