package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private Environment environment;
    private EmployeeService employeeService;
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeController(Environment environment, EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.environment = environment;
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }
    @GetMapping("/")
    public ResponseEntity<?> getStatus()
    {
        return ResponseEntity.ok("app is up listening on port: "+environment.getProperty("local.server.port"));
    }
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployee()
    {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployee());
    }
    @GetMapping("/employees/employeeId")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer employeeId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(employeeId));
    }
    @PostMapping("/employee/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
    }
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<List<Employee>> deleteById(@PathVariable("id") Integer employeeId) {
        employeeService.deleteById(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> UpdateById(@PathVariable("id") Integer employeeId ,@RequestBody Employee employee) {
        Employee e = employeeService.getEmployeeById(employeeId);
        e.setFirstName(employee.getFirstName());
        e.setLastName(employee.getLastName());
        e.setEmail(employee.getEmail());
        final Employee Updated = employeeRepository.save(e);
        return ResponseEntity.status(HttpStatus.OK).body(Updated);
    }

}

