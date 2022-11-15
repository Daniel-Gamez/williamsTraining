package com.williams.repo;
import com.williams.model.Hero;

import java.util.ArrayList;
import java.util.List;

public class Heroes {

    private List<Hero> heroList;

    public List<Hero> getHeroList()
    {
        if (heroList == null) {

            heroList
                    = new ArrayList<>();
        }

        return  heroList;
    }

    public void
    setHeroList(List<Hero> heroList)
    {
        this.heroList
                = heroList;
    }
}
