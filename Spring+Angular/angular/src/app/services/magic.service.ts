import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MagicService {

  baseUrl = 'https://api.magicthegathering.io/v1/cards';

  constructor(public http: HttpClient) { }

  getRequest(url?: string): Observable<any> {
    if (url) {
      return this.http.get(url);
    } else {
      return this.http.get(this.baseUrl);
    }
  }
}
