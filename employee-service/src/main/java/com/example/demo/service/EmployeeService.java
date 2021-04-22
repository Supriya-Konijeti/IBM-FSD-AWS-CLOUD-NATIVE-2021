package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    public Employee createEmployee(Employee employee);
    public Employee getEmployeeById(Integer employeeId);
    public List<Employee> getAllEmployee();
    public void deleteById(Integer employeeId);
}
