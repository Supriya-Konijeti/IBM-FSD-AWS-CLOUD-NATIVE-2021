package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.repo.CityRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Validated
@RequestMapping({"/api"})
public class CityController {
    @Autowired
    private CityRepository cityRepository;

    public CityController() {
    }

    @GetMapping({"/city"})
    public List<City> getCities() {
        return this.cityRepository.findAll();
    }

    @GetMapping({"/city/{id}"})
    public ResponseEntity<City> getCityById(@PathVariable("id") Integer cityId) throws ResourceNotFoundException {
        City user = (City)this.cityRepository.findById(cityId).orElseThrow(() -> {
            return new ResourceNotFoundException("Country not found :: " + cityId);
        });
        return ResponseEntity.ok().body(user);
    }

    @PostMapping({"/city"})
    public City createUser(@RequestBody @Valid City city) {
        return (City)this.cityRepository.save(city);
    }


    @PutMapping({"/city/{id}"})
    public ResponseEntity<City> updateUser(@PathVariable("id") Integer cityId, @RequestBody @Valid City cityDetails) throws ResourceNotFoundException {
        City city = (City)this.cityRepository.findById(cityId).orElseThrow(() -> {
            return new ResourceNotFoundException("Country/City not found :: " + cityId);
        });
        city.setNAME(cityDetails.getNAME());;
        City updatedCity = (City)this.cityRepository.save(city);
        return ResponseEntity.ok(updatedCity);
    }

    @DeleteMapping({"/city/{id}"})
    public Map<String, Boolean> deleteCity(@PathVariable("id") Integer cityId) throws ResourceNotFoundException {
        City city = (City)this.cityRepository.findById(cityId).orElseThrow(() -> {
            return new ResourceNotFoundException("Country not found :: " + cityId);
        });
        this.cityRepository.delete(city);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}