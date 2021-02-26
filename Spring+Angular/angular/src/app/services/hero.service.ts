import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Hero } from '../model/hero';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HeroService {
  
  
  constructor(private http:HttpClient) { }
    
    url='http://localhost:9876/api/'

    getHeroes():Observable<any> {
      return this.http.get(this.url+'heroes-list');      
    }
    deleteHero(id: number): Observable<any> {  
      return this.http.delete(this.url+'delete-hero/'+id);  
    }  

    createHero(hero: object): Observable<object> {  
      return this.http.post(`${this.url}`+'save-hero', hero);  
    } 
}
