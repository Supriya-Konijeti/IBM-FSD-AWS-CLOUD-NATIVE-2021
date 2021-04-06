package com.example.demo.service;

import com.example.demo.dto.AccountDto;
import com.example.demo.model.AccountModel;

import java.util.List;

public interface AccountService {

    public AccountDto createAccount(AccountDto accountDto);
    public AccountDto findByAccountId(String accountId);
    public AccountDto findByEmail(String email);
    public List<AccountModel> getAllAccount();
    public AccountDto updateAccount(String accountId, AccountDto accountDto);
    //public AccountDto findByFirstName(String firstName);
    public Integer deleteByAccountId(String accountId);
    public AccountDto findByLastName(String lastName);
    public Integer deleteByFirstName(String firstName);
    public List<AccountModel> getAccountByFirstName(String firstName);
    public AccountDto findByFirstNameAndLastName(String firstName,String lastName);
    public AccountDto findByFirstNameOrLastName(String firstName,String lastName);
}