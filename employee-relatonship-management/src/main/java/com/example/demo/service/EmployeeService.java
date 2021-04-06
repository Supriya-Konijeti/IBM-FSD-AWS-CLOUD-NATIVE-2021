package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeService {

    public List<Employee> getAllEmployee();
    public Employee findById(int theId);
    public Employee createEmployee(Employee employee);
    public Employee deleteEmployeeById(int theId);
    @Query(value="select * from EMPLOYEE_DETAIL e where e.first_name like %:keyword% or e.last_name like %:keyword% or e.email like %:keyword%", nativeQuery = true)
    List<Employee> findByKeyword(@Param("keyword") String keyword);
}