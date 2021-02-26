import { Component, OnInit } from '@angular/core';
import { Card } from 'src/app/model/card';
import { TrivialService } from 'src/app/services/trivial.service';

@Component({
  selector: 'app-trivial',
  templateUrl: './trivial.component.html',
  styleUrls: ['./trivial.component.scss']
})
export class TrivialComponent implements OnInit {

  result: any = {};
  cards: Card[] = [];
  points = 0;

  constructor(public service: TrivialService) { }

  ngOnInit(): void {
    this.service.getRequest().subscribe(
      (data) => this.processData(data),
      (error) => this.processError(error)
    );
  }

  processData(data: any): void {
    this.result = data;
    for (const jsonCard of this.result.results) {
      this.cards.push(new Card(jsonCard));
    }
  }

  processError(error: any): void {
    console.log(error);
  }

  updateScore(rightAnswer) {
    if (rightAnswer) {
      this.points += 2;
    }else {
      this.points += -1;
    }
  }

}
