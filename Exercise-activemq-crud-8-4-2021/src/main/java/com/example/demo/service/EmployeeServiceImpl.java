package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepoImpl;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        super();
        this.employeeRepoImpl = employeeRepo;
    }

    @Override
    public Collection<Employee> getAllEmployee() {
        // TODO Auto-generated method stub
        return employeeRepoImpl.getAllEmployee();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        // TODO Auto-generated method stub
        return employeeRepoImpl.getEmployeeById(id);
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
        return employeeRepoImpl.updateEmployee(id,employee);
    }
    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepoImpl.createEmployee(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepoImpl.deleteEmployee(id);
    }
}