import { Injectable } from '@angular/core';
import {Hero} from "./hero";
import {HttpClient, HttpHeaders} from "@angular/common/http";

import {Observable, of} from "rxjs";
import {MessageService} from "./message.service";
@Injectable({
  providedIn: 'root'
})
export class HeroService {

  URL: string = "http://localhost:8080/heroes"

  getHeroes(): Observable<Hero[]> {
    this.log("Hero Service: fetched heroes")
    return this.http.get<Hero[]>(this.URL);
  }
  getHero(id: number): Observable<Hero> {
    this.messageService.add(`Hero Service: Fetched Hero id = ${id}.`)
    return this.http.get<Hero>(this.URL + `/${id}`);
  };

  private log(message: string) {
    this.messageService.add(`hero service: ${message}`)
  }

  constructor(private messageService: MessageService, private http: HttpClient) { }
}

