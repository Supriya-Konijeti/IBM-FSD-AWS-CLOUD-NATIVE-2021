/*package com.example.demo.controller;

import com.example.demo.model.Country;
import com.example.demo.repo.CountryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    private CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
    @GetMapping("/Countries")
    public ResponseEntity<Country> createCountry(@RequestBody Country country){
        return ResponseEntity.ok(countryRepository.save(country));
    }
}*/
