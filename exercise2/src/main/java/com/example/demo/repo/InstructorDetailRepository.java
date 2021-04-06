package com.example.demo.repo;

import com.example.demo.model.Instructor;
import com.example.demo.model.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Integer> {
}
