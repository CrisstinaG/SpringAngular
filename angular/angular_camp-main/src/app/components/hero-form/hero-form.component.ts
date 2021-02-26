import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Hero } from 'src/app/model/hero';

@Component({
  selector: 'app-hero-form',
  templateUrl: './hero-form.component.html',
  styleUrls: ['./hero-form.component.scss']
})
export class HeroFormComponent implements OnInit {

  @Output() addHeroSignal = new  EventEmitter<Hero>();

  constructor() { }

  ngOnInit(): void {
  }

  addHero(heroName: any, heroDescription: any): void{
    this.addHeroSignal.emit(new Hero(heroName.value, heroDescription.value));
    heroName.value = '';
    heroDescription.value = '';
  }

}
