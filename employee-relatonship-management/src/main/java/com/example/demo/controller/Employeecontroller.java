package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class Employeecontroller {

    private EmployeeService employeeService;

    @Autowired
    public Employeecontroller(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String getEmployees(Model model)
    {
        List<Employee> list=employeeService.getAllEmployee();
        model.addAttribute("employees", list);
        return "list-employees";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // create model attribute to bind form data
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        return "employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
        // save the employee
        employeeService.createEmployee(theEmployee);
        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,
                                    Model theModel) {

        // get the employee from the service
        Employee theEmployee = employeeService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("employee", theEmployee);

        // send over to our form
        return "employee-form";
    }
    @RequestMapping("/delete")
    public String deleteEmployeeById(@RequestParam("employeeId") int theId){
        employeeService.deleteEmployeeById(theId);
        return "redirect:/employees/list";
    }

}