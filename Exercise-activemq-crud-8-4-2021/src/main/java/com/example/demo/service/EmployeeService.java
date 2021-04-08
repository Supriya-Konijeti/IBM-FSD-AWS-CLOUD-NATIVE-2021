package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    public Collection<Employee> getAllEmployee();
    public Employee getEmployeeById(Integer id);
    public Employee updateEmployee(Integer id,Employee employee);
    public Employee createEmployee(Employee employee);
    public void deleteEmployee(Integer id);
}
