package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private final Environment environment;
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService,Environment environment) {
        this.customerService = customerService;
        this.environment=environment;
    }
    @GetMapping("/")
    public ResponseEntity<String> getStatus()
    {
        return ResponseEntity.ok("customer service is up at port number: "+environment.getProperty("local.server.port"));
    }
    @PostMapping(path = "/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustoemr(customer));
    }

    @GetMapping(path = "/customers")
    public ResponseEntity<List<Customer>> displayCustomers()
    {
        return ResponseEntity.ok(customerService.displayAllCustomer());
    }
    @GetMapping(path="/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(customerService.findByCustomerId(id));
    }
    @GetMapping("/customers/{address}")
    public ResponseEntity<Customer> getCustomerByAddress(@PathVariable("address")String address){
        return ResponseEntity.ok(customerService.findCustomerByAddress(address));
    }
    @GetMapping("/customers/{name}")
    public ResponseEntity<Customer> getCustomerByName(@PathVariable("name")String name){
        return ResponseEntity.ok(customerService.findCustomerByName(name));
    }
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Integer> deleteCustomerByCustomerId(@PathVariable("id")Integer id){

        Integer s= customerService.deleteCustomerByCustomerId(id);
        return ResponseEntity.ok(s);
    }
    @DeleteMapping("/customers/{name}")
    public ResponseEntity<Integer> deleteCustomerByCustomerName(@PathVariable("name")String name){

           Integer s=     customerService.deleteCustomerByName(name);
        return ResponseEntity.ok(s);
    }
    @DeleteMapping("/customers/{address}")
    public ResponseEntity<Integer> deleteCustomerByCustomerAddress(@PathVariable("address")String address){

           Integer s=     customerService.deleteCustomerByAddress(address);
        return ResponseEntity.ok(s);
    }
   /* @GetMapping(path = "/customers")
    public ResponseEntity<Integer> deleteAllCustomers()
    {
        customerService.displayAllCustomer();
        Integer s=customerService.deleteAllCustomers();
        return ResponseEntity.ok(s);
    }*/

}