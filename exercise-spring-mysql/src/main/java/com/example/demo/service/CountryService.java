package com.example.demo.service;

import com.example.demo.model.City;
import com.example.demo.model.Country;

import java.util.List;

public interface CountryService {
    public List<Country> getCountry(String Name);
}
