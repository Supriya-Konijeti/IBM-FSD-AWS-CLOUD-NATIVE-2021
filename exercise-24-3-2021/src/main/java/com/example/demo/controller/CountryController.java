package com.example.demo.controller;

import com.example.demo.exception.CountryNotFoundException;
import com.example.demo.exception.ErrorResponse;
import com.example.demo.model.Country;
import com.example.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CountryController {
    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        super();
        this.countryService = countryService;
    }

    @GetMapping(path = "/countries", produces = "application/json")
    public ResponseEntity<Collection<Country>> findAllCountries() {

        return ResponseEntity.status(HttpStatus.OK).body(countryService.getAllCountry());
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleError(CountryNotFoundException e)
    {
        ErrorResponse response=new ErrorResponse();
        response.setErrorMessage(e.getMessage());
        response.setErrorReportTime(System.currentTimeMillis());
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @GetMapping(path = "/countries/{id}")
    public ResponseEntity<Country> getEmployeeById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(countryService.getCountryById(id));
    }

    /* @GetMapping(path ="/employees/{firstname}")
             public ResponseEntity<Employee> getEmployeeByFirstname(@PathVariable("firstname")String firstname){
         return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeByFirstName(firstname));
     }*/
    @PostMapping(path = "/countries", consumes = "application/json", produces = "application/json")

    public ResponseEntity<Country> createCustomer(@RequestBody Country country) {
        return ResponseEntity.status(HttpStatus.CREATED).body(countryService.createCountry(country));
    }

    @DeleteMapping(path = "countries/{id}")
    public Map<Integer,Boolean> deleteEmployee(@PathVariable(value="id")Integer id){
        Country country=countryService.getCountryById(id);
        countryService.deleteCountryr(id);
        Map <Integer,Boolean> response=new HashMap<>();
        response.put(1,Boolean.TRUE);
        return response;
    }
    @PutMapping(path = "/countriess/{id}")
    public ResponseEntity<Country> updateEmployee(@PathVariable Integer id,@RequestBody Country country)
    {
        Country e=countryService.updateCountry(id, country);
        return ResponseEntity.status(HttpStatus.OK).body(e);
    }
}
