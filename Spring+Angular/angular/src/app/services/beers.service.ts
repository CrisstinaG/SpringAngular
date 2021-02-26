import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BeersService {

  baseUrl = 'https://api.punkapi.com/v2/beers';

  constructor(public http: HttpClient) { }

  getRequest(dateString?: string): Observable<any> {
    if (dateString) {
      return this.http.get(this.baseUrl + '&date=' + dateString);
    } else {
      return this.http.get(this.baseUrl);
    }
  }
}
