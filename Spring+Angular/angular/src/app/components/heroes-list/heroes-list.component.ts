// import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
// import { Hero } from 'src/app/model/hero';


import { Component, OnInit,Input } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Hero } from 'src/app/model/hero';
import { HeroService } from 'src/app/services/hero.service';

@Component({
  selector: 'app-heroes-list',
  templateUrl: './heroes-list.component.html',
  styleUrls: ['./heroes-list.component.scss']
})
export class HeroesListComponent implements OnInit {

  @Input() heroesList: Hero[];  
  constructor(private service:HeroService, private router:Router) { }

  ngOnInit() {
    this.service.getHeroes().subscribe(data => {
      this.heroesList = data;
    });
  }

  deleteHero(id: number):void {  
    this.service.deleteHero(id)
      .subscribe(  
        data => {  
          console.log(data);           
          this.service.getHeroes().subscribe(data => {
            this.heroesList = data 
            })  
        },  
        error => console.log(error));  
  } 
  

}