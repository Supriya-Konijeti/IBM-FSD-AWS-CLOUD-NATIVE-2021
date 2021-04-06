package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
//@GetMapping("/rest")
public class CityController {
    @Autowired
private CityService cityService;
@Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
@GetMapping("/rest/cities/country=/{countryName}")
    public ResponseEntity<List<Country>> getBycountryName(@PathVariable("countryName") String countryName)
{
    List<City> list=cityService.getCityByCountryName(countryName);
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
}
}
