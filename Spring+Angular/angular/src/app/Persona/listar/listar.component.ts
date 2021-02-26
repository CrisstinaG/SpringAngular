import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Hero } from 'src/app/model/hero';
import { HeroService } from 'src/app/services/hero.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.scss']
})
export class ListarComponent implements OnInit {

  heroesList:Observable<Hero[]>;
  constructor(private service:HeroService, private router:Router) { }

  ngOnInit() {
    this.service.getHeroes().subscribe(data => {
      this.heroesList = data;
    });
  }
  

}
