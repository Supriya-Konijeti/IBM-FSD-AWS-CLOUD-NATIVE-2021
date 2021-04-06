package com.example.demo.controller;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        // create employees
        Employee emp1 = new Employee(1, "Leslie", "Andrews", "leslie@luv2code.com");
        Employee emp2 = new Employee(2, "Emma", "Baumgarten", "emma@luv2code.com");
        Employee emp3 = new Employee(3, "Avani", "Gupta", "avani@luv2code.com");
        // create the list
        List<Employee> theEmployees = new ArrayList<>();
        // add to the list
        theEmployees.add(emp1);
        theEmployees.add(emp2);
        theEmployees.add(emp3);
        // add to the spring model
        theModel.addAttribute("employees", theEmployees);
        return "list-employees";
    }
}
