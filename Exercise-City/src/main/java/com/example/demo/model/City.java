package com.example.demo.model;

import javax.persistence.*;
@Entity
@Table(name = "city_details")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "city_name")
    private String name;
    public City() {
        super();
    }

    public City(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "City [id=" + id + ", name=" + name + "]";
    }

}