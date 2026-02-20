import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { GamesComponent } from './games/games.component';
import { GameDetailComponent } from './game-detail/game-detail.component';
import { PlayGroundComponent } from './play-ground/play-ground.component';
import { CardDetailComponent } from './card-detail/card-detail.component';

import { GAME_SERVICE_TOKEN } from './services/game.service.interface';
import { GameFromAPIService } from './services/gameFromAPI.service';
import { GameSimulatorService } from './services/gameSimulator.service';


@NgModule({
  declarations: [
    AppComponent,
    GamesComponent,
    GameDetailComponent,
    PlayGroundComponent,
    CardDetailComponent
  ],
  imports: [
    BrowserModule,
    FormsModule, // <-- import the FormsModule before binding with [(ngModel)]
    HttpClientModule
  ],
  providers: [
    { provide: GAME_SERVICE_TOKEN, useClass: GameFromAPIService}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
