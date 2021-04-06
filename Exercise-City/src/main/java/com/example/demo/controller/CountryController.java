package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.repo.CityRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.demo.repo.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/*@RestController
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
    @DeleteMapping({"/city/{id}"})
    public Map<String, Boolean> deleteCity(@PathVariable("id") Integer cityId) throws ResourceNotFoundException {
        City city = (City)this.cityRepository.findById(cityId).orElseThrow(() -> {
            return new ResourceNotFoundException("Country not found :: " + cityId);
        });
        this.cityRepository.delete(city);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return response;
    }*/
@RestController
public class CountryController {
    private CountryRepository countryRepository;
    private CityRepository cityRepository;

    @Autowired
    public CountryController(CountryRepository countryRepository, CityRepository cityRepository) {
        super();
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }
    @GetMapping("/countries")
    public List<Country> getCountries() {
        return this.countryRepository.findAll();
    }
    @PostMapping("/countries/create")
    public ResponseEntity<Country> createCountry(@RequestBody Country country, @RequestParam("id") Integer id, @RequestParam("name")String name) {
        List<City> cities=new ArrayList<City>();
        City city=new City(id, name);
        cities.add(city);
        country.setCities(cities);
        cityRepository.saveAll(cities);
        return ResponseEntity.ok(countryRepository.save(country));
    }
    @PutMapping({"/country/{id}"})
    public ResponseEntity<Country> updateUser(@PathVariable("id") Integer id, @RequestBody @Valid Country countryDetails) throws ResourceNotFoundException {
        Country country = this.countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country/City not found :: " +id));
        country.setName(countryDetails.getName());;
        Country updatedCountry = this.countryRepository.save(country);
        return ResponseEntity.ok(updatedCountry);
    }
    @DeleteMapping({"/country/{id}"})
    public Map<String, Boolean> deleteCountry(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        Country country = this.countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country not found :: " + id));
        this.countryRepository.delete(country);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    @GetMapping("/city/country/{name}")
    public List<Country> getCountries(@PathVariable String name){
        return countryRepository.findAll().stream().filter(country -> Boolean.parseBoolean(country.getName()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

}