package com.example.demo.service;

import antlr.StringUtils;
import com.example.demo.model.City;
import com.example.demo.repo.CityRepository;
import com.example.demo.repo.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {
  Logger logger= LoggerFactory.getLogger(CityService.class);
  @Autowired
    private CountryRepository countryRepository;
  @Autowired
    private CityRepository cityRepository;

  public List<City> getCities(String name){
      List<City> all=new ArrayList<>();
      if(name!=null){
          all=cityRepository.findByCountryContaining(name);
      }else{
          all.addAll(cityRepository.findAll());
      }
      return all;
  }
}
