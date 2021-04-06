package com.example.demo.service;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.repo.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountrySreviceImpl implements CountryService{
private CountryRepository countryRepository;
    @Override
    public List<Country> getCountry(String Name) {
        List<Country> countries=countryRepository.getCountryName(Name);
        return countries;
    }
}
