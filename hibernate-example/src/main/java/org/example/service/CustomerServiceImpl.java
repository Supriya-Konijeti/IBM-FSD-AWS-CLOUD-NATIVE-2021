package org.example.service;

import org.example.dao.CustomerDao;
import org.example.dao.CustomerDaoImpl;
import org.example.entity.customer;
import org.example.exception.CustomerNotFoundException;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;
    {
        customerDao=new CustomerDaoImpl();
    }

    @Override
    public void createCustomer(customer customer) {
        customerDao.createCustomer(customer);
    }
    @Override
    public List<customer> getAllCustomer() {
        return customerDao.getAllCustomer();
    }
    @Override
    public customer getCustomerById(int customerId) {
        return customerDao.getCustomerById(customerId);
    }

    @Override
    public List<customer> getCustomerByName(String name) {
        return customerDao.getCustomerByName(name);
    }

    @Override
    public customer updateCustomer(int customerId) throws CustomerNotFoundException {
        return customerDao.updateCustomer(customerId);
    }

    @Override
    public customer removeCustomer(int cusromerId) {
        return customerDao.removeCustomer(cusromerId);
    }

}
