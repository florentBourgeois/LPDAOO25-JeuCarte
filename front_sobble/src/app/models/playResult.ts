import {Shape} from "./shape";
import {Card} from "./card";
import {PlayStatus} from "./playStatus";


export interface PlayResult {
  //playStatus is an enum that can be either Ok, Error or Game_Over
  playStatus: PlayStatus;
  newHand: Card;
}
