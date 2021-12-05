package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "two_liners_table")
public class TwoLineJoke {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String category;
    private String setupLine;
    private String punchLine;

    public TwoLineJoke() {
    }

    public TwoLineJoke(String category, String setupLine, String punchLine) {
        this.category = category;
        this.setupLine = setupLine;
        this.punchLine = punchLine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSetupLine() {
        return setupLine;
    }

    public void setSetupLine(String setupLine) {
        this.setupLine = setupLine;
    }

    public String getPunchLine() {
        return punchLine;
    }

    public void setPunchLine(String punchLine) {
        this.punchLine = punchLine;
    }

    @Override
    public String toString() {
        return "TwoLineJoke{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", setupLine='" + setupLine + '\'' +
                ", punchLine='" + punchLine + '\'' +
                '}';
    }
}