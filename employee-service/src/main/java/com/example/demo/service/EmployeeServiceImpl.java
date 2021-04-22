package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
@Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Integer employeeId) {
        return employeeRepository.getOne(employeeId);
}

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteById(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
