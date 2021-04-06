package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;

@SpringBootApplication
public class EmployeeRelationshipManagementApplication implements CommandLineRunner{

    private EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeRelationshipManagementApplication(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeRelationshipManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        employeeRepository.save(new Employee("John", "Doe", "john@email.com"));
        employeeRepository.save(new Employee("Marry", "Public", "marry@email.com"));
        employeeRepository.save(new Employee("Sachin", "Tendulkar", "sachin@email.com"));
    }

}