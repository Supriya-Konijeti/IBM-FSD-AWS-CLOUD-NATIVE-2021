package com.example.demo.controller;

import com.example.demo.Entity.City;
import com.example.demo.Entity.Country;
import com.example.demo.repo.CityRepository;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest")
public class CityController {
    @Autowired
    private CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    // @Autowired
   // public CityController(CityService cityService) {
       // this.cityService = cityService;
    //}

    /*@GetMapping("/cities/country=/{countryName}")
    public ResponseEntity<List<Country>> getBycountryName(@PathVariable("countryName") String countryName)
    {
        List<City> list=cityService.getCities(countryName);
        List<Country> responses=new ArrayList<>();
        Iterator<City> i=list.iterator();
        while(i.hasNext())
        {
            City m=i.next();
            Country model=new Country();
            model.setId(m.getId());
            model.setName(m.getName());
            responses.add(model);
        }
        return  ResponseEntity.ok(responses);
    }*/
    @GetMapping("/city/country/{name}")
public List<City> getCities(@PathVariable String name){
    return cityRepository.findAll().stream().filter(city -> city.getCountry().getName().startsWith(name))
            .collect(Collectors.toCollection(ArrayList::new));
    }
    @GetMapping({"/city"})
    public List<City> getCities() {
        return this.cityRepository.findAll();
    }
   /* @GetMapping({"/city/{id}"})
    public ResponseEntity<City> getCityById(@PathVariable("id") long id) {
        City user = (City)this.cityRepository.findById(id);/*.orElseThrow(() -> {
            return new ResourceNotFoundException("Country not found :: " + cityId);
        });*/
        /*return ResponseEntity.ok().body(user);
    }*/
}

