package com.example.demo.service;

import com.example.demo.dto.AccountDto;
import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.model.AccountModel;
import com.example.demo.repo.AccountRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@EnableTransactionManagement
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
        if(model==null) {
            throw new AccountNotFoundException("no such account number found."+accountId);
        }
        AccountDto dto=mapper.map(model, AccountDto.class);
        return dto;
    }
    /*@Override
    public AccountDto updateAccount(AccountDto accountDto) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        AccountModel model = mapper.map(accountDto, AccountModel.class);
        accountRepository.save(model);
        AccountDto dto= mapper.map(model, AccountDto.class);
        return dto;
    }*/
    @Override
    public AccountModel updateAccountDetails(Integer id, AccountDto accountDto) {
        AccountModel accountModel;
        accountModel = accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException("account"+id));
        accountModel.setFirstName(accountDto.getFirstName());
        accountModel.setLastName(accountDto.getLastName());
        accountModel.setEmail(accountDto.getEmail());
        ModelMapper mapper = new ModelMapper();
        AccountModel model = mapper.map(accountDto, AccountModel.class);
        return accountRepository.save(model);
    }
   /* @Override
    public AccountDto findByFirstName(String firstName) {
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountModel model=accountRepository.findByFirstName(firstName);
        if(model==null){
            throw new AccountNotFoundException("no ");
        }
        AccountDto dto=mapper.map(model,AccountDto.class);
        return dto;
    }*/
   // @Override
   // public AccountDto findByEmail(String )


    @Override
    public List<AccountModel> getAllAccount() {
        return accountRepository.findAll();
    }
/*private AccountRepository accountRepository;
    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountModel findById(int theId) {
        AccountModel theAccountModel = null;
        Optional<AccountModel> result=accountRepository.findById(theId);
        if(result.isPresent())
        {
            theAccountModel=result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find accountmodel id - " + theId);
        }

        return theAccountModel;
    }
    @Override
    public AccountModel createAccount(AccountModel accountModel) {
        return accountRepository.save(accountModel);
    }

    @Override
    public List<AccountModel> getAllAccount() {
        return accountRepository.findAll();
    }*/
}
