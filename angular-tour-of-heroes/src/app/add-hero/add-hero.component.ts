import { Component, OnInit } from '@angular/core';
import {Hero} from "../hero";
import {HeroService} from "../hero.service";
import  {Router} from "@angular/router";

@Component({
  selector: 'app-add-hero',
  templateUrl: './add-hero.component.html',
  styleUrls: ['./add-hero.component.css']
})
export class AddHeroComponent implements OnInit {

  hero: Hero = {
    id: 0,
    superName: ""
  }

  addHero(){
    this.heroService.addHero(this.hero).subscribe(_=>this.route.navigate(["/heroes"]));

  }

  constructor(private heroService: HeroService, private route: Router) {

  }

  ngOnInit(): void {
  }

}
