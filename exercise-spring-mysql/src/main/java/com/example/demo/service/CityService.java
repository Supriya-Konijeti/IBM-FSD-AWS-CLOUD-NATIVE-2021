package com.example.demo.service;

import com.example.demo.model.City;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CityService {
    //public List<City> getAllCities();
    public List<City> getCityByCountryName(String countryName);
}
