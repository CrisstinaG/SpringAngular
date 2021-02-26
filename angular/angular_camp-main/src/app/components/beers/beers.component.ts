import { Component, OnInit } from '@angular/core';
import { BeersService } from 'src/app/services/beers.service';
import { Options } from '@angular-slider/ngx-slider';

@Component({
  selector: 'app-beers',
  templateUrl: './beers.component.html',
  styleUrls: ['./beers.component.scss']
})
export class BeersComponent implements OnInit {

  result: any[];
  beers: any[] = [];

  value = 0;
  highValue = 5;
  options: Options = {
    floor: 0,
    ceil: 55,
    step: 0.1
  };

  constructor(public service: BeersService) { }

  ngOnInit(): void {
    this.service.getRequest().subscribe(
      (data) => this.processData(data),
      (error) => this.processError(error)
    );
  }

  processData(data: any): void {
    this.result = data;
    this.beers = [];
    for (const beer of this.result) {
      if (beer.abv >= this.value && beer.abv <= this.highValue) {
        this.beers.push(beer);
      }
    }
  }

  processError(error: any): void {
    console.log(error);
  }

  handleChange(value: number, highValue: number): void {
    this.beers = [];
    for (const beer of this.result) {
      if (beer.abv >= value && beer.abv <= highValue) {
        this.beers.push(beer);
      }
    }
  }


}
