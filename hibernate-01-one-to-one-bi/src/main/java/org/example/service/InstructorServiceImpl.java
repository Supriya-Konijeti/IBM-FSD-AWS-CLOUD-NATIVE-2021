package org.example.service;

import org.example.Dao.InstructorDao;
import org.example.Dao.InstructorDaoImpl;
import org.example.entity.Instructor;
import org.example.entity.InstructorDetails;
import org.example.exception.InstructorNotFoundException;

import java.util.List;

public class InstructorServiceImpl implements InstructorService {
    private InstructorDao instructorDao;


    public InstructorServiceImpl() {
        instructorDao = new InstructorDaoImpl();
    }

    @Override
    public Instructor createInstructor(Instructor instructor) {
        return instructorDao.createInstructor(instructor);
    }

    @Override
    public InstructorDetails createInstructorDetails(InstructorDetails instructorDetails) {
        return instructorDao.createInstructorDetails(instructorDetails);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorDao.getAllInstructors();
    }

    @Override
    public Instructor updateInstructor(int instructorId) throws InstructorNotFoundException, InstructorNotFoundException {
        return instructorDao.updateInstructor(instructorId);
    }

    @Override
    public Instructor removeInstructor(int instructorId) throws InstructorNotFoundException {
        return instructorDao.removeInstructor(instructorId);
    }
}
