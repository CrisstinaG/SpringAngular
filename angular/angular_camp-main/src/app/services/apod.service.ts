import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable()
export class ApodService {

  baseUrl = 'https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY';

  constructor(public http: HttpClient) { }

  getRequest(dateString?: string): Observable<any> {
    if (dateString) {
      return this.http.get(this.baseUrl + '&date=' + dateString);
    } else {
      return this.http.get(this.baseUrl);
    }
  }
}
