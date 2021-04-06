package com.example.demo.repo;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
}
