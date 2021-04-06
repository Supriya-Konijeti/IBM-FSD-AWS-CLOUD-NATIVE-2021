package com.example.demo.repo;

import com.example.demo.model.Country;

import java.util.Collection;

public interface CountryRepo {
    public Collection<Country> getAllCountry();
    public Country getCountryById(Integer id);
    public Country updateCountry(Integer id,Country country);
    public Country createCountry(Country country);
    public void deleteCountry(Integer id);

}
