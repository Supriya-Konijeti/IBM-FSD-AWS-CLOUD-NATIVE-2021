package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;
@Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        super();
        this.customerRepository=customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    @Override
    public Customer findById(int theId) {
        // TODO Auto-generated method stub
        Customer theCustomer = null;
        Optional<Customer> result=customerRepository.findById(theId);
        if(result.isPresent())
        {
            theCustomer=result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find customer id - " + theId);
        }

        return theCustomer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll() ;
    }
}
