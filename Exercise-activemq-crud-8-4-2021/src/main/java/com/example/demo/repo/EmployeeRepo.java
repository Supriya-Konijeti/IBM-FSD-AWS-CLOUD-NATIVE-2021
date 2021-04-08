package com.example.demo.repo;

import com.example.demo.model.Employee;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
    public Collection<Employee> getAllEmployee();
    public Employee getEmployeeById(Integer id);
    public Employee updateEmployee(Integer id,Employee employee);
    public Employee createEmployee(Employee employee);
    public void deleteEmployee(Integer id);
   public void deleteAllEmployees();
   
}
