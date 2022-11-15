import { Component, OnInit } from '@angular/core';
import {Hero} from "../hero";
import {HeroService} from "../hero.service";
import {MessageService} from "../message.service";

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  heroes: Hero[] = [];
  // selectedHero?: Hero
  //
  // onSelect(hero: Hero){
  //   this.selectedHero = hero;
  //   this.messageService.add(`Heroes: Select a Hero ID = ${hero.id}`)
  // }

  constructor(private heroService: HeroService) { }
  // constructor(private heroService: HeroService , private messageService: MessageService) { }

  ngOnInit(): void {
   this.heroService.getHeroes().subscribe(heroes => this.heroes = heroes);
  }

}
