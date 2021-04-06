package com.example.demo.service;

import com.example.demo.Entity.City;
import com.example.demo.repo.CityRepository;
import com.example.demo.repo.CountryRepository;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
@Service
public class CityService {
    Logger logger = LoggerFactory.getLogger(CityService.class);

    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CityRepository cityRepository;


    public List<City> getCities(String name) {
        List<City> all = new ArrayList<>();

        // This is just a small application so I'm not considering performance in this queries and coding in a a way that it's easy to maintain
        if (name != null && StringUtils.hasText(name)) {
            all = cityRepository.findByCountryNameContaining(name);
        } else {
            all.addAll(cityRepository.findAll());
        }

        return all;
    }
}
