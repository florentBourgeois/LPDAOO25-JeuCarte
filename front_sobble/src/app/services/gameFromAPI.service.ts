import {Injectable} from '@angular/core';
import {GameForList} from "../models/gameForList";
import {Game} from "../models/game";
import {HelpFactory} from "../models/helpFactory";
import {PlayResult} from "../models/playResult";
import {PlayStatusEnum} from "../models/playStatus";
import {GameServiceInterface} from "./game.service.interface";
import {Environment} from "../../environment/environment";
import {HttpClient} from "@angular/common/http";
import {firstValueFrom} from "rxjs";
import {GameSimulatorService} from "./gameSimulator.service";

@Injectable({
  providedIn: 'root'
})
export class GameFromAPIService implements GameServiceInterface{

  private gameSimulator : GameSimulatorService = new GameSimulatorService();
  constructor(private http: HttpClient) { }


  async getAllGames(): Promise<GameForList[]> {
    console.debug("getAllGames api call");
    return firstValueFrom(this.http.get<GameForList[]>(`${Environment.domain}/game`));
  }

  createGame(numberOfShapesPerCard: number): Promise<Game> {
    console.debug("createGame api call");
    return firstValueFrom(this.http.get<Game>(`${Environment.domain}/game/new/${numberOfShapesPerCard}`));
  }

  getGame(id: number): Promise<Game> {
    return firstValueFrom(this.http.get<Game>(`${Environment.domain}/game/${id}`));
  }

  play(gameId: number, shapeId: number): Promise<PlayResult> {
    const body = {"gameId": gameId, "shapeId": shapeId};

    return firstValueFrom(this.http.post<PlayResult>(`${Environment.domain}/game/play`, body));
  }



}
