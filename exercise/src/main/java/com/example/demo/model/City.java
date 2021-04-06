package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="city")
public class City {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="name",unique = true)
    private String name;
    //@OneToOne(cascade = CascadeType.ALL)
    @/*(Join)*/Column(name = "Country",nullable=false)
    private Country country;

    public City() {
    }

    public City(Integer id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
