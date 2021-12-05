package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "one_liners_table")
public class OneLineJoke {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String joke;

    public OneLineJoke() {
    }

    public OneLineJoke(String joke) {
        this.joke = joke;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    @Override
    public String toString() {
        return "OneLineJoke{" +
                "id=" + id +
                ", joke='" + joke + '\'' +
                '}';
    }
}