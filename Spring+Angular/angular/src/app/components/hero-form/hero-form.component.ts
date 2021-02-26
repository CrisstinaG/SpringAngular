import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Hero } from 'src/app/model/hero';
import { HeroService } from 'src/app/services/hero.service';

@Component({
  selector: 'app-hero-form',
  templateUrl: './hero-form.component.html',
  styleUrls: ['./hero-form.component.scss']
})
export class HeroFormComponent implements OnInit {

  @Output() addHeroSignal = new  EventEmitter<Hero>();

  constructor(private service:HeroService) { }

  hero:Hero;
  submitted = false;  

  ngOnInit(): void {
     this.submitted=false;  
  }

   

  saveHero(saveHero){  
    this.hero=new Hero();     
    this.hero.name=this.HeroName.value;  
    this.hero.description=this.HeroDescription.value;   
    this.submitted = true;  
    this.save();  
  }  
  save() {  
    this.service.createHero(this.hero)
      .subscribe(data => console.log(data), error => console.log(error));  
    this.hero = new Hero();  
  }  

  herosaveform=new FormGroup({  
    name:new FormControl('' , [Validators.required , Validators.minLength(5) ] ),  
    description:new FormControl('',[Validators.required,Validators.email])    
  });

  get HeroName(){  
    return this.herosaveform.get('name');  
  }  
  
  get HeroDescription(){  
    return this.herosaveform.get('description');  
  }  

  addHeroForm(){  
    this.submitted=false;
    this.herosaveform.reset();  
  }
  



}
