package com.williams.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.williams.repos.HeroRepository;
import org.springframework.beans
        .factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http
        .ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet
        .support.ServletUriComponentsBuilder;
import java.util.stream.*;


import com.williams.model.Hero;


@RestController
@RequestMapping("/heroes")
@CrossOrigin(origins = "http://localhost:4200")

public class HeroController {

//    private List<Hero> heroes = generateHeroes();

    @Autowired
    HeroRepository heroRepository;


    @GetMapping
    public ResponseEntity<List<Hero>> getHeroes() {
    //    var heroes = heroRepository.findAll();
        var heroes = heroRepository.searchHeroByName("stick");
        return new ResponseEntity<>(heroes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hero> getHeroById(@PathVariable int id) {
//        Hero hero = heroes.stream()
//                .filter(h -> h.getId() == id)
//                .findAny()
//                .orElse(null);
        var hero = heroRepository.findById(id);
        if(hero.isPresent()) {
            return new ResponseEntity<>(hero.get(), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteHeroById(@PathVariable int id) {
        if (heroRepository.existsById(id)) {
            heroRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity updateHero(@RequestBody Hero edited) {
//        Hero oldHero = heroes.stream()
//                .filter(h -> h.getId() == edited.getId())
//                .findFirst()
//                .orElse(null);
//        if (oldHero != null) {
//            int index = heroes.indexOf(oldHero);
//            heroes.set(index, edited);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
        if (heroRepository.existsById(edited.getId())) {
            heroRepository.saveAndFlush(edited);
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }

    @PostMapping
    public ResponseEntity<Hero> addHero(@RequestBody Hero toAdd) {
//        int maxId = heroes.stream().mapToInt(h->h.getId()).max().orElse(0);
//        toAdd.setId(maxId+1);
//        heroes.add(toAdd);

        var newHero = heroRepository.saveAndFlush(toAdd);
        return new ResponseEntity<>(newHero, HttpStatus.CREATED);
    }



    private List<Hero> generateHeroes() {
        List<Hero> heroes = new ArrayList<>();

        heroes.add(new Hero(11, "Superman"));
        heroes.add(new Hero(12, "Green Lantern"));
        heroes.add(new Hero(13, "Wonder Woman"));
        heroes.add(new Hero(14, "Wolverine"));
        heroes.add(new Hero(15, "Dr. Nice"));
        heroes.add(new Hero(16, "Bombasto"));
        heroes.add(new Hero(17, "Celeritas"));
        heroes.add(new Hero(18, "Magneta"));
        heroes.add(new Hero(19, "RubberMan"));
        heroes.add(new Hero(20, "Dynama"));
        heroes.add(new Hero(21, "Dr. IQ"));
        heroes.add(new Hero(23, "Magma"));
        heroes.add(new Hero(24, "Cat Woman"));


        return heroes;
    }



}
