package com.williams.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans
        .factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http
        .ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet
        .support.ServletUriComponentsBuilder;
import java.util.stream.*;

// Import the above-defined classes
// to use the properties of those
// classes

import com.williams.model.Hero;
import com.williams.data.HeroDAO;
import com.williams.repo.Heroes;

// REST Controller
@RestController
@RequestMapping("/heroes")
@CrossOrigin(origins = "http://localhost:4200")

public class HeroController {

    @Autowired
    private HeroDAO heroDAO;

    // Implementing a GET method
    // to get the list of all
    // the employees

    @GetMapping
    public List<Hero> getHeroes()
    {

        return heroDAO.getAllHeroes().getHeroList();
    }

    @GetMapping("/{id}")
    public Hero getHeroById(@PathVariable int id) {
        return heroDAO.getAllHeroes().getHeroList().stream().filter(h -> h.getId() == id).findAny().orElse(null);
    }

    @PostMapping
    public ResponseEntity<Object> addHero(
            @RequestBody Hero hero)
    {
        Integer id
                = heroDAO
                .getAllHeroes()
                .getHeroList()
                .size()
                + 1;
        hero.setId(id);

        heroDAO.addHero(hero);

        //URI location
//                = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(hero.getId())
//                .toUri();
        return new ResponseEntity<>(hero, HttpStatus.CREATED);
    }


}
