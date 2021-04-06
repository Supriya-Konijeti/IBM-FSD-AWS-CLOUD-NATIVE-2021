package com.example.demo.controller;

import com.example.demo.dto.AccountDto;
import com.example.demo.model.AccountModel;
import com.example.demo.service.AccountService;
import com.example.demo.shared.AccountRequestModel;
import com.example.demo.shared.AccountResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        super();
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
    /*@PutMapping("/accounts/{id}")
    public ResponseEntity<AccountResponseModel> updateAccount(@RequestBody AccountRequestModel accRequestModel)
    {
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountDto accountDto=mapper.map(accRequestModel, AccountDto.class);
        accountDto.setAccountId(accountDto.getAccountId());
        AccountDto response= accountService.updateAccount(accountDto);
        AccountResponseModel model=mapper.map(response, AccountResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(model);

    }*/
    @PutMapping("/accounts/details/{id}")
    public ResponseEntity<AccountResponseModel> updateAccount(@PathVariable Integer id, @RequestBody AccountRequestModel accountRequestModel) {
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountDto accountDto = mapper.map(accountRequestModel, AccountDto.class);
        AccountModel response = accountService.updateAccountDetails(id, accountDto);

        // entity to DTO
        AccountResponseModel model = mapper.map(response, AccountResponseModel.class);

        return ResponseEntity.ok().body(model);
    }
    @GetMapping(path = "/accounts")
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
        AccountResponseModel response=mapper.map(dto, AccountResponseModel.class);
        return ResponseEntity.ok(response);
    }
    /*@GetMapping("/accounts/{firstName}")
    public ResponseEntity<AccountResponseModel> getAccountByFirstName(@PathVariable("firstName")String firstName){
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountDto dto=accountService.findByFirstName(firstName);
        AccountResponseModel response=mapper.map(dto,AccountResponseModel.class);
        return  ResponseEntity.ok(response);
    }*/
}
