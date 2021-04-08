package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.exception.ErrorResponse;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import java.util.Collection;
import java.util.Map;

import javax.jms.Queue;
@RestController
@RequestMapping("/api")
public class MessageController {
	private Queue queue;
	private JmsTemplate jmsTemplate;
	 private EmployeeService employeeService;
	@Autowired
	public MessageController(Queue queue, JmsTemplate jmsTemplate,EmployeeService employeeService) {
		super();
		this.queue = queue;
		this.jmsTemplate = jmsTemplate;
		this.employeeService=employeeService;
	}
	@GetMapping(path = "/allemployees")
	 public ResponseEntity<String> publishMessage0(@RequestBody Employee employee){
			jmsTemplate.convertAndSend(queue, employee);
		
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("All Employees displayed successfully... ");
}
	/*@ExceptionHandler
    public ResponseEntity<ErrorResponse> handleError(EmployeeNotFoundException e)
    {
        ErrorResponse response=new ErrorResponse();
        response.setErrorMessage(e.getMessage());
        response.setErrorReportTime(System.currentTimeMillis());
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }*/
	@GetMapping("/employees/{id}")
	public ResponseEntity<?> publishMessage(@PathVariable("id") Integer id) {
		jmsTemplate.convertAndSend(queue, id);
	
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Employee displayed successfully..." );
	}
	 
	 @PostMapping(path = "/employees")
	 public ResponseEntity<String> publishMessage1(@RequestBody Employee employee){
			jmsTemplate.convertAndSend(queue, employee);
		
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Employee created successfully... ");
}
	 @DeleteMapping(path = "/employees/{id}")
	    public ResponseEntity<String> publishMessage2(@PathVariable(value="id")Integer id){
		 jmsTemplate.convertAndSend(queue, id);
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Employee deleted successfully... ");
	 }
	 @PutMapping(path = "/employees/{id}")
	    public ResponseEntity<String> publishMessage3(@PathVariable Integer id,@RequestBody Employee employee)
	    {
		 jmsTemplate.convertAndSend(queue, id);
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Employee updated successfully... ");
	 }
	    
}