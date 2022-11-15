package com.williams.model;

public class Hero {

    private Integer id;
    private String superName;

    public Hero() {}

    public Hero (Integer id, String superName) {
        super();
        this.id = id;
        this.superName = superName;

    }

    @Override
    public String toString()
    {
        return "Hero [id="
                + id + ", superName="
                + superName + "]";
    }

    public Integer getId()
    {
        return  id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getSuperName() {
        return superName;
    }
    public void setSuperName(
            String superName)
    {
        this.superName = superName;
    }
}
