package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.repo.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class Controller {
    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

   /* @GetMapping("/cities/{Name}")
    public ResponseEntity<List<City>> getCityByCountry(@PathVariable(value = "Name") String Name) {
        City city = cityRepository.findByName(Name);
        return List < ResponseEntity.ok().body(city) >;
    }*/
}