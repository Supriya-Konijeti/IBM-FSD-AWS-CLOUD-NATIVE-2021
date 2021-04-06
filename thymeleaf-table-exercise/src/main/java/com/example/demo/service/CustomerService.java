package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer createCustomer(Customer customer);
    public List<Customer> getAllCustomers();

    public Customer findById(int theId);
}
