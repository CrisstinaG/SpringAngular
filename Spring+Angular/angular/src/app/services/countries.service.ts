import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CountriesService {

  baseUrl = 'https://restcountries.eu/rest/v2/all';

  constructor(public http: HttpClient) { }

  getRequest(url?: string): Observable<any> {
    if (url) {
      return this.http.get(url);
    } else {
      return this.http.get(this.baseUrl);
    }
  }
}