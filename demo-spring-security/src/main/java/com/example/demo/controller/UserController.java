package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @RequestMapping("/hello")
    public ResponseEntity<String> seyHello()
    {
        return ResponseEntity.ok("hello world spring security");
    }

}
