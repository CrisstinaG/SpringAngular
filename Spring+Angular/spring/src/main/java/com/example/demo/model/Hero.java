package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hero")
public class Hero {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String description;

    public Hero() {
    }

    public Hero(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Hero(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setdesciption(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", Name ='" + name + '\'' +
                ", Description ='" + description + '\'' +                
                '}';
    }

}
