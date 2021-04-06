package org.example.Dao;

import org.example.entity.Instructor;
import org.example.entity.InstructorDetails;
import org.example.exception.InstructorNotFoundException;

import java.util.List;

public interface InstructorDao {
    public Instructor createInstructor(Instructor instructor);

    public List<Instructor> getAllInstructors();

    public Instructor updateInstructor(int instructorId) throws InstructorNotFoundException, InstructorNotFoundException;

    public Instructor removeInstructor(int instructorId) throws InstructorNotFoundException;

    public InstructorDetails createInstructorDetails(InstructorDetails instructorDetails);
}
