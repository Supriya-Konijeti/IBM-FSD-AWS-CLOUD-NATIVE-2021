package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="country")
public class Country {
    @Id
    @GeneratedValue
    private Integer Id;
    @Column(name="name",nullable = false)
    private String Name;
   // @OneToOne(mappedBy="City", cascade=CascadeType.ALL)
   // private City city;
    public Country() {
    }

    public Country(Integer id, String name) {
        Id = id;
        Name = name;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                '}';
    }
}
