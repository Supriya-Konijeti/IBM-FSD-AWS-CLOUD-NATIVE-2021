package org.example.dao;

import org.example.exception.InstructorNotFoundException;
import org.example.model.Instructor;

import java.util.List;

public interface InstructorDao {
    public Instructor createInstructor(Instructor instructor);
    public List<Instructor> getAllInstructors();
    public Instructor updateInstructor(int instructorId) throws InstructorNotFoundException;
    public Instructor removeCustomer(int cusromerId)throws InstructorNotFoundException;
}
