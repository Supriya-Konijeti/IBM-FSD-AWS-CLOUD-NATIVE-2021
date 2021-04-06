package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;
@Service
public class    EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee createEmployee(Employee employee) {
        // TODO Auto-generated method stub
        return employeeRepository.save(employee);
    }

    @Override
    public Employee deleteEmployeeById(int theId) {
        Optional<Employee> employee=employeeRepository.findById(theId);
        if(employee.isPresent()){
           employeeRepository.deleteById(theId);
        }else{
            throw new RuntimeException("Did not find employee by id-"+theId);
        }
        return null;
    }

    @Override
    public List<Employee> findByKeyword(String keyword) {
        return employeeRepository.findByKeyword(keyword);
    }


    @Override
    public Employee findById(int theId) {
        // TODO Auto-generated method stub
        Employee theEmployee = null;
        Optional<Employee> result=employeeRepository.findById(theId);
        if(result.isPresent())
        {
            theEmployee=result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }


    @Override
    public List<Employee> getAllEmployee() {
        // TODO Auto-generated method stub
        return employeeRepository.findAll();
    }
}