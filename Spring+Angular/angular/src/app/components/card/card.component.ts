import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Card } from 'src/app/model/card';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {

  @Input() card: Card;
  @Output() signal = new EventEmitter<boolean>();

  constructor() { }

  ngOnInit(): void {
  }

  handleClick(answer: string): void {
    this.card.answered = true;
    this.card.currentAnswer = answer;
    if(answer === this.card.rightAnswer) {
      this.signal.emit(true);
    }else {
      this.signal.emit(false);
    }
  }

  getClass(answer: string): string {
    if (this.card.answered){
      if (answer === this.card.rightAnswer) {
        return 'btn btn-success btn-block disabled';
      }else if (answer === this.card.currentAnswer && this.card.currentAnswer !== this.card.rightAnswer){
        return 'btn btn-danger btn-block disabled';
      }else {
        return 'btn btn-secondary btn-block disabled';
      }
    }else {
      return 'btn btn-primary btn-block';
      }
  }

}
