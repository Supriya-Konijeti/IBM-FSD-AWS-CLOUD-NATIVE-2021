package com.example.demo;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymeleafTableExerciseApplication implements CommandLineRunner {
private CustomerRepository customerRepository;
    @Autowired
    public ThymeleafTableExerciseApplication(CustomerRepository customerRepository) {
        super();
        this.customerRepository=customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafTableExerciseApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {

        customerRepository.save(new Customer("John", "Doe", "ongole"));
        customerRepository.save(new Customer("Marry", "Public", "rudravaram"));
        customerRepository.save(new Customer("Sachin", "Tendulkar", "ethamukkala"));
    }
}
