import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Card} from "../models/card";

@Component({
  selector: 'app-card-detail',
  templateUrl: './card-detail.component.html',
  styleUrls: ['./card-detail.component.css']
})
export class CardDetailComponent {

  @Input() card!: Card;
  @Input() isHand: boolean = false;
  @Output() shapeSelected = new EventEmitter<number>();



  onShapeClick(shapeID: number){
    console.log("onShapeClick with: " + shapeID);
    if(!this.isHand) return; // prevent the call from the reference card
    this.shapeSelected.emit(shapeID);

  }
}
