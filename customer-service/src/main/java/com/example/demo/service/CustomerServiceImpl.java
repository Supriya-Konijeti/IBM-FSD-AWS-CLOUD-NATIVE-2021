package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public Customer createCustoemr(Customer customer) {
        // TODO Auto-generated method stub
        return customerRepository.save(customer);
    }

    @Override
    public Integer deleteCustomerByCustomerId(Integer id) {
        return customerRepository.deleteCustomerByCustomerId(id);
    }

    @Override
    public List<Customer> displayAllCustomer() {
        // TODO Auto-generated method stub
        return customerRepository.findAll();
    }
    @Override
    public Customer findCustomerByAddress(String address) {
        return customerRepository.findCustomerByAddress(address);
    }
    @Override
    public Customer findCustomerByName(String name) {
        return customerRepository.findCustomerByName(name);
    }
    @Override
    public Customer findByCustomerId(Integer id) {
        return customerRepository.findByCustomerId(id);
    }

    @Override
    public Integer deleteCustomerByName(String name) {
        return customerRepository.deleteCustomerByName(name);
    }

   /* @Override
    public Integer deleteAllCustomers() {
        return customerRepository.de;
    }*/

    @Override
    public Integer deleteCustomerByAddress(String address) {
        return customerRepository.deleteCustomerByAddress(address);
    }

}