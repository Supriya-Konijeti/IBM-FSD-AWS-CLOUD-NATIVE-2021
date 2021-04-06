package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;
    @GetMapping("/list")
    public String listCustomers(Model theModel) {
        // create employees
        Customer cus1 = new Customer(1, "Leslie", "Andrews", "Kolkata");
        Customer cus2 = new Customer(2, "Emma", "Baumgarten", "Bangalore");
        Customer cus3 = new Customer(3, "Avani", "Gupta", "Hyderabad");
        // create the list
        List<Customer> theCustomers = new ArrayList<>();
        // add to the list
        theCustomers.add(cus1);
        theCustomers.add(cus2);
        theCustomers.add(cus3);
        // add to the spring model
        theModel.addAttribute("customers", theCustomers);
        return "list-customers";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // create model attribute to bind form data
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        // save the employee
            customerService.createCustomer(theCustomer);
        // use a redirect to prevent duplicate submissions
        return "redirect:/customers/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel) {

        // get the employee from the service
        Customer theCustomer = customerService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("customer", theCustomer);

        // send over to our form
        return "customer-form";
    }
}

