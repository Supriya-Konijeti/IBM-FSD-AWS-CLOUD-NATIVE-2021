package org.example.service;

import org.example.entity.Instructor;
import org.example.entity.InstructorDetails;
import org.example.exception.InstructorNotFoundException;

import java.util.List;

public interface InstructorService {
    public Instructor createInstructor(Instructor instructor);

    public InstructorDetails createInstructorDetails(InstructorDetails instructorDetails);

    public List<Instructor> getAllInstructors();

    public Instructor updateInstructor(int instructorId) throws InstructorNotFoundException, InstructorNotFoundException;

    public Instructor removeInstructor(int instructorId) throws InstructorNotFoundException;
}
