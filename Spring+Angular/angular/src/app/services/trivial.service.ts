import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TrivialService {

  baseUrl = 'https://opentdb.com/api.php?amount=10';

  constructor(public http: HttpClient) { }

  getRequest(url?: string): Observable<any> {
    if (url) {
      return this.http.get(url);
    } else {
      return this.http.get(this.baseUrl);
    }
  }
}