import { Component, OnInit } from '@angular/core';
import {Hero} from '../../model/hero';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.scss']
})
export class HeroesComponent implements OnInit {

  heroes: Hero[] = [];

  constructor() { }

  ngOnInit(): void {
    this.heroes.push(new Hero('Superman', 'Man of steel'));
    this.heroes.push(new Hero('Batman', 'Dark knight'));
    this.heroes.push(new Hero('Spiderman', 'Spiddy'));
  }

  addHero(newHero: Hero): void{
    console.log(newHero);
    this.heroes.push(newHero);
  }

  removeHero(index: number): void {
    this.heroes.splice(index, 1);
  }

}
