package com.example.demo.repo;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {
    @Query
    public List<Country> findByNameContaining(String Name);

}
