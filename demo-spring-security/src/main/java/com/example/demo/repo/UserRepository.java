package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserModel;
@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

}
