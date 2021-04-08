package com.example.demo.controller;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.exception.ErrorResponse;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Queue;

@RestController

public class EmployeeController {
	private Queue queue;
	private JmsTemplate jmsTemplate;
    private EmployeeService employeeService;
    
    @Autowired
    public EmployeeController(Queue queue, JmsTemplate jmsTemplate, EmployeeService employeeService) {
		super();
		this.queue = queue;
		this.jmsTemplate = jmsTemplate;
		this.employeeService = employeeService;
	}
	@GetMapping(path = "/employees", produces = "application/json")
	 public ResponseEntity<Collection<Employee>> publishMessage0(){
		//jmsTemplate.convertAndSend(queue, employee);
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployee());
    }
    /*public ResponseEntity<Collection<Employee>> findAllEmployee() {
    	jmsTemplate.convertAndSend(queue, employees);
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployee());
    }*/
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleError(EmployeeNotFoundException e)
    {
        ErrorResponse response=new ErrorResponse();
        response.setErrorMessage(e.getMessage());
        response.setErrorReportTime(System.currentTimeMillis());
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @GetMapping(path = "/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
    	jmsTemplate.convertAndSend(queue, id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(id));
    }

    /* @GetMapping(path ="/employees/{firstname}")
             public ResponseEntity<Employee> getEmployeeByFirstname(@PathVariable("firstname")String firstname){
         return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeByFirstName(firstname));
     }*/
    @PostMapping(path = "/employees", consumes = "application/json", produces = "application/json")

    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
    	//jmsTemplate.convertAndSend(queue, employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
    }

    @DeleteMapping(path = "employees/{id}")
    public Map<Integer,Boolean> deleteEmployee(@PathVariable(value="id")Integer id){
        Employee employee=employeeService.getEmployeeById(id);
        employeeService.deleteEmployee(id);
        Map <Integer,Boolean> response=new HashMap<>();
        response.put(1,Boolean.TRUE);
        return response;
    }
    @PutMapping(path = "/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id,@RequestBody Employee employee)
    {
        Employee e=employeeService.updateEmployee(id, employee);
        jmsTemplate.convertAndSend(queue, employee);
        return ResponseEntity.status(HttpStatus.OK).body(e);
    }

}