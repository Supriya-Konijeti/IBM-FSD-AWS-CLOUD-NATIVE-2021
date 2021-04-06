package com.example.demo.controller;

import java.util.*;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import com.example.demo.model.AccountModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.AccountDto;
import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.exception.EmailNotFoundException;
import com.example.demo.service.AccountService;
import com.example.demo.shared.AccountRequestModel;
import com.example.demo.shared.AccountResponseModel;
import com.example.demo.shared.ErrorResponse;

@RestController
@Validated
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/accounts")
    public ResponseEntity<AccountResponseModel> createAccount(@RequestBody AccountRequestModel accRequestModel)
    {
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountDto accountDto=mapper.map(accRequestModel, AccountDto.class);
        accountDto.setAccountId(UUID.randomUUID().toString());
        AccountDto response= accountService.createAccount(accountDto);
        AccountResponseModel model=mapper.map(response, AccountResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(model);

    }
    @GetMapping(path = "/accounts/all")
    public List<AccountDto> getAllAccount() {
        ModelMapper mapper=new ModelMapper();
        return accountService.getAllAccount().stream().map(post->mapper.map(post,AccountDto.class)).collect(Collectors.toList());
    }
    @GetMapping("/accounts/{accountId}")
    public ResponseEntity<AccountResponseModel> getAccountByAccountId(@PathVariable("accountId") String accountId)
    {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountDto dto=accountService.findByAccountId(accountId);
        if(dto==null)
        {
            throw new AccountNotFoundException("no such account with id: "+accountId);
        }
        AccountResponseModel response=mapper.map(dto, AccountResponseModel.class);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/accounts/email/{email}")
    public ResponseEntity<AccountDto> findAccountByEmail(@PathVariable("email") String email)
    {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountDto dto=accountService.findByEmail(email);
        if(dto==null)
        {
            throw new EmailNotFoundException("email not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PutMapping("/accounts/{accountid}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable("accountid") String accountId,
                                                    @RequestBody AccountRequestModel requestModel)
    {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountDto dto= mapper.map(requestModel, AccountDto.class);
        AccountDto d= accountService.updateAccount(accountId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(d);
    }
    @GetMapping("/accounts/allfirstName/{firstName}")
    public ResponseEntity<List<AccountResponseModel>> getByfirstName(@PathVariable("firstName") String firstName)
    {
        List<AccountModel> list=accountService.getAccountByFirstName(firstName);
        List<AccountResponseModel> responses=new ArrayList<AccountResponseModel>();
        Iterator<AccountModel> i=list.iterator();
        while(i.hasNext())
        {
            AccountModel m=i.next();
            AccountResponseModel model=new AccountResponseModel();
            model.setAccountId(m.getAccountId());
            model.setEmail(m.getAccountId());
            model.setFirstName(m.getFirstName());
            model.setLastName(m.getLastName());
            responses.add(model);
        }
        return ResponseEntity.ok(responses);
    }
    @GetMapping("/accounts/{firstName}/{lastName}")
    public ResponseEntity<AccountDto> findAccountByFirstNameAndLastName(@PathVariable("firstName")String firstName,@PathVariable("lastName") String lastName){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountDto dto=accountService.findByFirstNameAndLastName(firstName, lastName);
        if(dto==null)
        {
            throw new EmailNotFoundException("Account not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
   @GetMapping("/accounts/Or/{firstName}/{lastName}")
    public ResponseEntity<AccountDto> findAccountByFirstNameOrLastName(@PathVariable("firstName")String firstName,@PathVariable("lastName") String lastName){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountDto dto=accountService.findByFirstNameOrLastName(firstName, lastName);
        if(dto==null)
        {
            throw new EmailNotFoundException("Account not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    /* @GetMapping("/accounts/firstname/{firstName}")
    public ResponseEntity<AccountDto> findAccountByFirstName(@PathVariable("firstName") String firstName)
    {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountDto dto=accountService.findByFirstName(firstName);
        if(dto==null)
        {
            throw new EmailNotFoundException("firstname not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }*/
    @GetMapping("/accounts/lastname/{lastName}")
    public ResponseEntity<AccountDto> findAccountByLastName(@PathVariable("lastName") String lastName)
    {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountDto dto=accountService.findByLastName(lastName);
        if(dto==null)
        {
            throw new EmailNotFoundException("lastname not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @DeleteMapping("/accounts/{accountId}")
public ResponseEntity<Integer> deleteAccount(@PathVariable("accountId") String accountId)
    {
        Integer result=accountService.deleteByAccountId(accountId);
        if(result<1){
            throw  new AccountNotFoundException("no account found");
        }
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/accounts/delete/{firstName}")
    public ResponseEntity<Integer> deleteAccount1(@PathVariable("firstName") String firstName){
        Integer result=accountService.deleteByFirstName(firstName);
        if(result<1){
            throw new AccountNotFoundException("no account found");
        }
        return ResponseEntity.ok(result);
    }
}
