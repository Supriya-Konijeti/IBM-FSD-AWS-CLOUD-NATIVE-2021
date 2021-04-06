package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    @Query
    public Customer findByCustomerId(Integer id);
    @Query
    public Customer findCustomerByAddress(String address);
    @Query
    public Customer findCustomerByName(String name);
    @Query
    public Integer deleteCustomerByCustomerId(Integer id);
    @Query
    public Integer deleteCustomerByName(String name);
@Query
   public Integer deleteCustomerByAddress(String address);

}