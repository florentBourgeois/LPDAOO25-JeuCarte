import {Shape} from "./shape";
import {Card} from "./card";


export interface PlayStatus {
  name: PlayStatusEnum;
  scoreValue: number;
}

export enum PlayStatusEnum {
  OK,
  ERROR,
  ERROR_OBVIOUS,
  CHEAT,
  GAME_OVER
}
