package com.example.demo.controller;

import com.example.demo.dto.CustomerDto;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.exception.EmailNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.shared.CustomerRequestModel;
import com.example.demo.shared.CustomerResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }
    /*@PostMapping("/customers")
    public ResponseEntity<CustomerResponseModel> createCustomer(@RequestBody CustomerRequestModel customerRequestModel){
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CustomerDto customerDto=mapper.map(customerRequestModel, CustomerDto.class);
        customerDto.setAccountId(UUID.randomUUID().toString());
        CustomerDto response=customerService.createCustomer(customerDto);
        CustomerResponseModel model=mapper.map(response, CustomerResponseModel.class) ;
        return ResponseEntity.status(HttpStatus.CREATED).body(model);
    }*/
    @GetMapping("/customers/{customerId}")
    public ResponseEntity<CustomerResponseModel> getCustomerByCustomerId(@PathVariable ("customerId") String customerId){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CustomerDto dto=customerService.findByCustomerId(customerId);
        if(dto== null){
            throw new CustomerNotFoundException("no");
        }
        CustomerResponseModel response=mapper.map(dto,CustomerResponseModel.class);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/customers/email/{email}")
    public ResponseEntity<CustomerDto> findCustomerByEmail(@PathVariable("email") String email) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CustomerDto dto = customerService.findByEmail(email);
        if (dto == null) {
            throw new EmailNotFoundException("email not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<Integer> deleteCustomer(@PathVariable("customerId") String customerId) {

        Integer result = customerService.deleteByCustomerId(customerId);
        if (result < 1) {
            throw new CustomerNotFoundException("no customer found.");
        }
        return ResponseEntity.ok(result);

    }

   /* @PutMapping("/customers/{customerId}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("customerId") String customerId,
                                                    @RequestBody CustomerRequestModel requestModel)
    {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CustomerDto dto= mapper.map(requestModel, CustomerDto.class);
        CustomerDto d= customerService.updateCustomer(customerId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(d);
    }*/
    @GetMapping("/customers/firstName/{firstName}")
    public ResponseEntity<List<CustomerResponseModel>> getByfirstName(@PathVariable("firstName") String firstName)
    {
        List<Customer> list=customerService.getCustomerByFirstName(firstName);
        List<CustomerResponseModel> responses=new ArrayList<CustomerResponseModel>();
        Iterator<Customer> i=list.iterator();
        while(i.hasNext())
        {
           Customer m=i.next();
            CustomerResponseModel model=new CustomerResponseModel();
           // model.setCustomerId(m.getCustomerId());
            model.setEmail(m.getCustomerId());
            model.setFirstName(m.getFirstName());
            model.setLastName(m.getLastName());
            responses.add(model);
        }
        return ResponseEntity.ok(responses);
    }

}
