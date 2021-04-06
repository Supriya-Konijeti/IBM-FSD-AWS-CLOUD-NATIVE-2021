package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.Query;

public interface CustomerService {

    public Customer createCustoemr(Customer customer);
    public Integer deleteCustomerByCustomerId(Integer id);
    public List<Customer> displayAllCustomer();
    public Customer findCustomerByAddress(String address);
    public Customer findCustomerByName(String name);
    public Customer findByCustomerId(Integer id);
    public Integer deleteCustomerByName(String name);
    //public  Integer deleteAllCustomers();
    public Integer deleteCustomerByAddress(String address);
}