package com.williams.data;
import com.williams.repo.Heroes;
import org.springframework.stereotype.Repository;
import com.williams.model.Hero;

@Repository

public class HeroDAO {

    private static Heroes list
            = new Heroes();

    static
    {
        list.getHeroList().add(
                new Hero(
                        11,
                        "Superman"));

        list.getHeroList().add(
                new Hero(
                        12,
                        "Green Lantern"));

        list.getHeroList().add(
                new Hero(
                        13,
                        "Wonder Woman"));

        list.getHeroList().add(
                new Hero(
                        14,
                        "Wolverine"));
        list.getHeroList().add(
                new Hero(
                        15,
                        "Dr. Nice"));
        list.getHeroList().add(
                new Hero(
                        16,
                        "Bombasto"));
        list.getHeroList().add(
                new Hero(
                        17,
                        "Celeritas"));
        list.getHeroList().add(
                new Hero(
                        18,
                        "Magneta"));
        list.getHeroList().add(
                new Hero(
                        19,
                        "RubberMan"));

    }

    public Heroes getAllHeroes() {

        return list;
    }

    public void addHero (Hero hero)
    {
        list.getHeroList()
                .add(hero);
    }


}
