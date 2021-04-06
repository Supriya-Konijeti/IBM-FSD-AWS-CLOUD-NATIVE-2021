package com.example.demo.service;

import com.example.demo.model.City;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityServiceIMPL implements CityService{
    CityServiceIMPL cityRepository;

    public CityServiceIMPL(CityServiceIMPL cityRepository) {
        this.cityRepository = cityRepository;
    }

   /* @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }*/

    @Override
    public List<City> getCityByCountryName(String countryName) {
        List<City> cities=cityRepository.getCityByCountryName(countryName);
        return cities;
    }
}
