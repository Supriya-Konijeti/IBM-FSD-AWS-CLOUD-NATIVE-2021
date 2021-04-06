package com.example.demo.model;
import javax.persistence.*;

@Entity
@Table(name = "CITY")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "NAME")
    private String NAME;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    public City() {
    }

    public City(String NAME) {
        this.NAME = NAME;
    }

    public long getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = (long)id;
    }

    public String getNAME() {
        return this.NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}

