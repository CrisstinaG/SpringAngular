import { Component, OnInit } from '@angular/core';
import { CountriesService } from 'src/app/services/countries.service';

@Component({
  selector: 'app-countries',
  templateUrl: './countries.component.html',
  styleUrls: ['./countries.component.scss']
})
export class CountriesComponent implements OnInit {

  result = [];
  countries = [];
  model = {ascendent: true, order: 0};

  constructor(public service: CountriesService) { }

  ngOnInit(): void {
    this.service.getRequest().subscribe(
      (data) => this.processData(data),
      (error) => this.processError(error)
    );
  }

  processData(data: any): void {
    this.result = data;
    this.countries = data.map((country, index) => {
      let name = '';
      if (country.translations.es !== null) {
        name = country.translations.es;
      }else {
        name = country.name;
      }
      return {name: name, capital: country.capital, population: country.population, area: country.area, index: index};
    });
  }

  processError(error: any): void {
    console.log(error);
  }

  handleClick() {
    console.log('handleClick(): ' + this.model);
  }

}
