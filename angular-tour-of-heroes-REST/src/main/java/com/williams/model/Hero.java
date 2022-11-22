package com.williams.model;

import javax.persistence.*;

@Entity
@Table(name="Heroes")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="supername")
    private String superName;

    public Hero (int id, String superName) {
        this.id = id;
        this.superName = superName;

    }
    public Hero() { }
    public int getId()
    {
        return  id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSuperName() {
        return superName;
    }
    public void setSuperName(String superName) { this.superName = superName; }
}
