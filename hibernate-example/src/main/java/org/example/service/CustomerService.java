package org.example.service;

import org.example.entity.customer;
import org.example.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    public void createCustomer(customer customer);
    public List<customer> getAllCustomer();
    public customer getCustomerById(int customerId);
    public List<customer> getCustomerByName(String name);
    public customer updateCustomer(int customerId) throws CustomerNotFoundException;
    public customer removeCustomer(int cusromerId);
}
