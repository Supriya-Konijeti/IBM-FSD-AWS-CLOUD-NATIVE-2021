package com.example.demo.model;
import javax.persistence.*;
@Entity
@Table(name="country")
public class Country {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="name",nullable = false)
    private String name;
   // @OneToOne(mappedBy="City", cascade=CascadeType.ALL)
   // private City city;
    public Country() {
    }
    public Country(Integer id, String countryName) {
        this.id = id;
        this.name = name;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { id = id; }

    public String getName() {
        return name;
    }

    public void setName(String cpountryName) {
        name = name;
    }
    @Override
    public String toString() {
        return "Country{" + "Id=" + id + ", Name='" + name + '\'' + '}';
    }
}
