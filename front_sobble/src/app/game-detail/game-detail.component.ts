import {Component, Inject, Input} from '@angular/core';
import {GameForList} from "../models/gameForList";
import {GAME_SERVICE_TOKEN, GameServiceInterface} from "../services/game.service.interface";

@Component({
  selector: 'app-game-detail',
  templateUrl: './game-detail.component.html',
  styleUrls: ['./game-detail.component.css']
})
export class GameDetailComponent {

  @Input() game!: GameForList;
  gameNameBeforeUpdate : string = "";


  constructor(@Inject(GAME_SERVICE_TOKEN) private gameService: GameServiceInterface) {}


  onInputFocus(){
    this.gameNameBeforeUpdate = this.game.name;
  }

  onInputBlur(){
    this.game.name= this.gameNameBeforeUpdate;
  }

}
