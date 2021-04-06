package com.example.demo.service;

import com.example.demo.exception.AccountNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountDto;
import com.example.demo.model.AccountModel;
import com.example.demo.repo.AccountRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        super();
        this.accountRepository = accountRepository;
    }
    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        // TODO Auto-generated method stub
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountModel model = mapper.map(accountDto, AccountModel.class);
        accountRepository.save(model);
        AccountDto dto= mapper.map(model, AccountDto.class);
        return dto;
    }
    @Override
    public AccountDto findByAccountId(String accountId) {
        // TODO Auto-generated method stub
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountModel model=accountRepository.findByAccountId(accountId);
        if(model==null)
        {
            return null;
        }
        else
        {
            AccountDto dto=mapper.map(model, AccountDto.class);
            return dto;
        }

    }
    @Override
    public List<AccountModel> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    @Transactional
    public AccountDto updateAccount(String accountId, AccountDto accountDto) {
       AccountModel accountModel = accountRepository.findByAccountId(accountId);
        if(accountModel==null){
                   throw new AccountNotFoundException("Account not found..");
        }
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountModel model=mapper.map(accountDto,AccountModel.class);
        accountModel.setFirstName(model.getFirstName());
        accountModel.setLastName(model.getLastName());
        accountModel.setEmail(model.getEmail());
       accountRepository.save(accountModel);
       AccountDto accDto=mapper.map(accountModel,AccountDto.class);
       return accDto;

    }
    /*@Override
    public AccountDto findByFirstName(String firstName) {
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountModel model=accountRepository.findByFirstName(firstName);
        System.out.println(model);
        return (mapper.map(model,AccountDto.class));
    }*/
    @Override
    public AccountDto findByLastName(String lastName) {
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountModel model=accountRepository.findByLastName(lastName);
        System.out.println(model);
        return (mapper.map(model,AccountDto.class));
    }

    @Override
    @Transactional
    public Integer deleteByAccountId(String accountId) {
       return accountRepository.deleteByAccountId(accountId);
    }
    @Override
    @Transactional
    public Integer deleteByFirstName(String firstName){
        return accountRepository.deleteByFirstName(firstName);
    }

    @Override
    public List<AccountModel> getAccountByFirstName(String firstName) {
        List<AccountModel> accounts=accountRepository.findByFirstName(firstName);
        return accounts;
    }

    @Override
    public AccountDto findByEmail(String email) {
        // TODO Auto-generated method stub
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountModel model=accountRepository.findByEmail(email);
        System.out.println(model);
        return (mapper.map(model, AccountDto.class));
    }
    @Override
    public AccountDto findByFirstNameAndLastName(String firstName,String lastName){
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountModel model=accountRepository.findByFirstNameAndLastName(firstName,lastName);
        System.out.println(model);
        return (mapper.map(model,AccountDto.class));
    }
    @Override
    public AccountDto findByFirstNameOrLastName(String firstName,String lastName){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountModel model=accountRepository.findByFirstNameOrLastName(firstName, lastName);
        System.out.println(model);
        return (mapper.map(model,AccountDto.class));
    }
}