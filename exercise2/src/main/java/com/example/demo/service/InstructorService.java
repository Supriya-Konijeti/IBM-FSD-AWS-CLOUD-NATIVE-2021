package com.example.demo.service;

import com.example.demo.model.Instructor;
import com.example.demo.model.InstructorDetail;

import java.util.List;

public interface InstructorService {
    public List<Instructor> getAllInstructor();
    public List<InstructorDetail> getAllInstructorDetail();
}
