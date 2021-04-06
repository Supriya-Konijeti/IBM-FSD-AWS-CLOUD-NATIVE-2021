package com.example.demo.repo;

import com.example.demo.exception.CountryNotFoundException;
import com.example.demo.model.Country;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CountryRepoImpl implements CountryRepo{
private CountryRepo countryRepo;
    private Map<Integer,Country> countryMap;
    {
        countryMap=new HashMap<Integer, Country>();
        countryMap.put(1, new Country(UUID.randomUUID().toString(), "INDIA", 1200000000));
        countryMap.put(2, new Country(UUID.randomUUID().toString(), "AMERICA", 500000000));
        countryMap.put(3, new Country(UUID.randomUUID().toString(), "CHINA", 1500000000));
        countryMap.put(4, new Country(UUID.randomUUID().toString(), "Sourav", 900000000));
    }
    @Override
    public Collection<Country> getAllCountry() {
        return countryMap.values();
    }

    @Override
    public Country getCountryById(Integer id) {
        Country country=countryMap.get(id);
        if(country==null)
        {
            throw new CountryNotFoundException("no such ecountry found");
        }
        return country;
    }

    @Override
    public Country updateCountry(Integer id, Country country) {
        Country tempCountry=countryMap.get(id);
        if(tempCountry==null)
        {
            throw new CountryNotFoundException("no country found with the given id: "+id);
        }
       tempCountry.setCountryName(country.getCountryName());
        tempCountry.setPopulation(country.getPopulation());
        countryMap.remove(id);
        countryMap.put(id, tempCountry);
        return tempCountry;
    }

    @Override
    public Country createCountry(Country country) {
        return null;
    }

    @Override
    public void deleteCountry(Integer id) {

    }
}
