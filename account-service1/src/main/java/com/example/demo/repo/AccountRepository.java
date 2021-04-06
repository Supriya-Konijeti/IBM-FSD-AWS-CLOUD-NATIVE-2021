package com.example.demo.repo;

import com.example.demo.dto.AccountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AccountModel;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Integer> {
    @Query
    public AccountModel findByAccountId(String accountId);
    @Query
    public AccountModel findByEmail(String email);
    //@Query
    //public AccountModel findByFirstName(String firstname);
    @Query
    public Integer deleteByAccountId(String accountId);
    @Query
    public AccountModel findByLastName(String lastname);
    @Query
    public Integer deleteByFirstName(String firstName);
    @Query
    public List<AccountModel> findByFirstName(String firstName);
    @Query
    public AccountModel findByFirstNameAndLastName(String firstName,String lastName);
    @Query
    public  AccountModel findByFirstNameOrLastName(String firstName,String lastName);
}