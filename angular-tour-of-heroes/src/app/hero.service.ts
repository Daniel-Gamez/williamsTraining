import { Injectable } from '@angular/core';
import {Hero} from "./hero";
import {HttpClient, HttpHeaders} from "@angular/common/http";

import {catchError, Observable, of} from "rxjs";
import {map, tap} from "rxjs/operators";
import {MessageService} from "./message.service";
import {error} from "@angular/compiler-cli/src/transformers/util";
import * as http from "http";
@Injectable({
  providedIn: 'root'
})
export class HeroService {

  URL: string = "http://localhost:8080/heroes"
  options = {
    headers : new HttpHeaders({'Content-Type': "application/json"})
  }

  addHero(hero: Hero): Observable<Hero> {
    return this.http.post<Hero>(this.URL, hero, this.options)
      .pipe(tap(_=> this.log("Hero Service: added hero")),
        catchError(this.handleError<Hero>("Adding hero")))
  }

  deleteHero(hero: Hero): Observable<any> {
    return this.http.delete(this.URL + `/${hero.id}`)
      .pipe(tap(_=> this.log("Hero deleted: " + hero.id)),
        catchError(this.handleError<any>("Delete Hero")))
  }

  updateHero(hero: Hero): Observable<any> {
    return this.http.put(this.URL, hero, this.options)
      .pipe(tap(_ => this.log("Hero Service: updated hero")),
        catchError(this.handleError<any>("Update heroes")))

  }

  getHeroes(): Observable<Hero[]> {
    return this.http.get<Hero[]>(this.URL)
      .pipe(tap(_ => this.log("Hero Service: fetched heroes")),
        catchError(this.handleError<Hero[]>("Get heroes",[])));
  }

  getHero(id: number): Observable<Hero> {
    return this.http.get<Hero>(this.URL + `/${id}`)
      .pipe(tap(_ => this.log(`Hero Service: Fetched Hero id = ${id}.`)),
      catchError(this.handleError<Hero>(`Get Hero ${id}`)));
  }

  private log(message: string) {
    this.messageService.add(`hero service: ${message}`)
  }

  private handleError<T>(operation: string = "Operation", result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      this.log(`${operation} failed: ${error.message}`)
      return of(result as T);
    }
  }

  constructor(private messageService: MessageService, private http: HttpClient) { }

}

