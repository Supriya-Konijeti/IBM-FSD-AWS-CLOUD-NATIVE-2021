package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/service1")
public class MyController {
	private BookService bookService;
	private Environment environment;
	@Autowired
	public MyController(BookService bookService,Environment environment) {
		super();
		this.environment=environment;
		this.bookService = bookService;
	}
@GetMapping("/books")
public ResponseEntity<List<Book>> getAllBooks(){
	return ResponseEntity.ok(bookService.findAllBooks());
}
	@GetMapping("/books/{authorName}")
	public ResponseEntity<List<Book>> findBooksByAuthorName(@PathVariable("authorName") String authorName)
	{
		return ResponseEntity.ok(bookService.findByAuthorName(authorName));
	}

	@GetMapping("/hello")
	public ResponseEntity<String> sayHello(){
		return ResponseEntity.ok("hello from service1 "+environment.getProperty("local.server.port"));
	}

}
