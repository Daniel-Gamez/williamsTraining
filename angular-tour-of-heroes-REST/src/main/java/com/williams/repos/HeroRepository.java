package com.williams.repos;

import com.williams.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface HeroRepository extends JpaRepository<Hero, Integer> {

    @Procedure("SEARCH_HERO_BY_NAME")
    List<Hero> searchHeroByName(String searchTerm);

}
