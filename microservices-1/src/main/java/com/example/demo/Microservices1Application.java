package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;


@SpringBootApplication
@EnableEurekaClient
public class Microservices1Application implements CommandLineRunner{

		private BookDao bookDao;
		
		
		public Microservices1Application(BookDao bookDao) {
			super();
			this.bookDao = bookDao;
		}

		public static void main(String[] args) {
			SpringApplication.run(Microservices1Application.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
			bookDao.save(new Book(1, "Pro Spring", 10, "auth-1"));
			bookDao.save(new Book(2, "Pro Hibernate", 11, "auth-2"));
		}
		
}
