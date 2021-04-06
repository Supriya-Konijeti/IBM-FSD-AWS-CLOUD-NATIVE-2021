package com.example.demo;

import com.example.demo.model.AccountModel;
import com.example.demo.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountServiceApplication implements CommandLineRunner {
private AccountRepository accountRepository;
@Autowired
    public AccountServiceApplication(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
accountRepository.save(new AccountModel(1,"cjdscd","fdsaxds","xdsatxds","trsres"));

    }
}