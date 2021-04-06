package com.example.demo.service;

import com.example.demo.dto.AccountDto;
import com.example.demo.model.AccountModel;

import java.util.Collection;
import java.util.List;

public interface AccountService {
    public AccountDto createAccount(AccountDto accountDto);
    public List<AccountModel> getAllAccount();
    public AccountDto findByAccountId(String accountId);
    public AccountModel updateAccountDetails(Integer id, AccountDto accountDto);
    // public AccountDto updateAccount(AccountDto accountDto);
   // public AccountDto findByFirstName(String firstName);
}
