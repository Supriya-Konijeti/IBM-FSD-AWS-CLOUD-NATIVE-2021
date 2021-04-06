package com.example.demo.repo;

import com.example.demo.Entity.City;
import com.example.demo.Entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CityRepository  extends JpaRepository<City, Long> {
@Query
    List<City> findById(long id);
    @Query
    List<City> findByCountryNameContaining(String name);
}

