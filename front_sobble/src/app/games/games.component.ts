import {Component, Inject} from '@angular/core';
import {GameForList} from "../models/gameForList";
import {Game} from "../models/game";
import {GAME_SERVICE_TOKEN, GameServiceInterface} from "../services/game.service.interface";



@Component({
  selector: 'app-games',
  templateUrl: './games.component.html',
  styleUrls: ['./games.component.css']
})
export class GamesComponent {

  gameList : GameForList[] = [];
  selectedGameForList : GameForList | undefined;
  selectedGame : Game | undefined;


  constructor(@Inject(GAME_SERVICE_TOKEN) private gameService: GameServiceInterface) {
    this.gameService.getAllGames()
      .then(gameList => {
        console.debug("getAllGames response:", gameList);
        this.gameList = gameList;
      })
      .catch(error => {
        console.error("Erreur lors de la récupération de la liste des jeux :", error);
      });
  }

  createNewGame(numberOfShapesPerCard: number){
    this.gameService.createGame(numberOfShapesPerCard)
      .then(game => {
        let newGame : GameForList = {id: game.id, name: game.name};
        this.gameList.push(newGame);
      })
      .catch(error => {
        console.error("Error creating new game:", error);
      });
  }

  onSelect(game: GameForList){
    this.selectedGameForList = game;
    this.gameService.getGame(game.id)
      .then(game => {
        console.dir(game);
        console.log("hand card : " + game.hand);
        this.selectedGame = game;
      })
      .catch(error => {
        console.error("Erreur lors de la récupération du jeu :", error);
      });
  }

  protected readonly Number = Number;
}
