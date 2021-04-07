package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceApplication implements CommandLineRunner{
	private BookDao bookDao;
	
	
	public MicroserviceApplication(BookDao bookDao) {
		super();
		this.bookDao = bookDao;
	}
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);
		System.out.println("hello");
	}
	@Override
	public void run(String... args) throws Exception {
		bookDao.save(new Book(1, "Pro Spring", 10, "auth-1"));
		bookDao.save(new Book(2, "Pro Hibernate", 11, "auth-2"));
	}
}
