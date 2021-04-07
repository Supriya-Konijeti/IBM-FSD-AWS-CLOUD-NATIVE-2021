package com.example.demo.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service2")
public class MyController {
	@GetMapping("/hello")
	public ResponseEntity<?> sayHello(){
		return ResponseEntity.ok("hello from service2");
	}

}
