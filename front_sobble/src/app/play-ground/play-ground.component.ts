import {Component, Inject, Input} from '@angular/core';
import {GameForList} from "../models/gameForList";
import {Game} from "../models/game";
import {PlayStatusEnum} from "../models/playStatus";
import {GAME_SERVICE_TOKEN, GameServiceInterface} from "../services/game.service.interface";

@Component({
  selector: 'app-play-ground',
  templateUrl: './play-ground.component.html',
  styleUrls: ['./play-ground.component.css']
})
export class PlayGroundComponent {

  @Input() game! : Game;

  constructor(@Inject(GAME_SERVICE_TOKEN) private gameService: GameServiceInterface) {}


  playShape(shapeID: number){
    console.log("playShape with: " + shapeID);
    this.gameService.play(this.game.id, shapeID)
      .then(playResult => {
        console.debug("play result :", playResult);
        console.debug("play status :", playResult.playStatus);
        let playStatusName : PlayStatusEnum = PlayStatusEnum[playResult.playStatus.name as unknown as keyof typeof PlayStatusEnum];
        console.debug("play status converted:", playStatusName);

        switch (playStatusName) {
          case PlayStatusEnum.OK:
            let tmpCard = this.game.hand;
            this.game.hand = playResult.newHand;
            this.game.referenceCard = tmpCard;
            this.game.score += playResult.playStatus.scoreValue;
            break;
          case PlayStatusEnum.GAME_OVER:
            // updte game with server info
            this.gameService.getGame(this.game.id)
              .then(game => {
                this.game = game;
              })
              .catch(error => {
                console.error("Erreur lors de la récupération du jeu :", error);
              });
            break;
          case PlayStatusEnum.ERROR:
          case PlayStatusEnum.ERROR_OBVIOUS:
          case PlayStatusEnum.CHEAT:
            this.game.score += playResult.playStatus.scoreValue;
            break;
          default:
            console.error("Status du play :", playResult.playStatus.name);
        }

      })
      .catch(error => {
        console.error("Erreur lors du play :", error);
      })
  }
}
