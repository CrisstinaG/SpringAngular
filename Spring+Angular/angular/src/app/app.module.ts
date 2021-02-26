import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { CalculatorComponent } from './components/calculator/calculator.component';
import { KeyboardComponent } from './components/keyboard/keyboard.component';
import { DisplayComponent } from './components/display/display.component';
import { CalculatorService } from './services/calculator.service';
import { HeroesComponent } from './components/heroes/heroes.component';
import { HeroesListComponent } from './components/heroes-list/heroes-list.component';
import { HeroFormComponent } from './components/hero-form/hero-form.component';
import { ApodComponent } from './components/apod/apod.component';
import { ApodService } from './services/apod.service';
import { YouTubePlayerModule } from '@angular/youtube-player';
import { ApodDatePickerComponent } from './components/apod-date-picker/apod-date-picker.component';
import { ApodShowComponent } from './components/apod-show/apod-show.component';
import { BeersComponent } from './components/beers/beers.component';
import { AbvPipe } from './pipes/abv.pipe';
import { NgxSliderModule } from '@angular-slider/ngx-slider';
import { FormComponent } from './components/form/form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { CountriesComponent } from './components/countries/countries.component';
import { SortPipe } from './pipes/sort.pipe';
import { TrivialComponent } from './components/trivial/trivial.component';
import { CardComponent } from './components/card/card.component';
import { ScoreComponent } from './components/score/score.component';
import { MagicComponent } from './components/magic/magic.component';
import { ListarComponent } from './Persona/listar/listar.component';
import { AddComponent } from './Persona/add/add.component';
import { EditComponent } from './Persona/edit/edit.component'; // CLI imports AppRoutingModule
import { HeroService } from './services/hero.service';


@NgModule({
  declarations: [
    AppComponent,
    CalculatorComponent,
    KeyboardComponent,
    DisplayComponent,
    HeroesComponent,
    HeroesListComponent,
    HeroFormComponent,
    ApodComponent,
    ApodDatePickerComponent,
    ApodShowComponent,
    BeersComponent,
    AbvPipe,
    FormComponent,
    PageNotFoundComponent,
    CountriesComponent,
    SortPipe,
    TrivialComponent,
    CardComponent,
    ScoreComponent,
    MagicComponent,
    ListarComponent,
    AddComponent,
    EditComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    HttpClientModule,
    YouTubePlayerModule,
    NgxSliderModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [CalculatorService, ApodService,HeroService],
  bootstrap: [AppComponent]
})
export class AppModule { }
