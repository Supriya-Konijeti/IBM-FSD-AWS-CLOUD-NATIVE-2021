package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.service.UserService;
import com.example.demo.shared.UserRequestModel;
import com.example.demo.shared.UserResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;
@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel userRequestModel){
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto=mapper.map(userRequestModel,UserDto.class);
        userDto.setUserId(UUID.randomUUID().toString());
        UserDto response=userService.createUser(userDto);
        UserResponseModel model=mapper.map(response,UserResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(model);
    }
    @PutMapping("/users/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("userId") String userId,
                                                    @RequestBody UserRequestModel requestModel)
    {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
       UserDto dto= mapper.map(requestModel, UserDto.class);
        UserDto d= userService.updateUser(userId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(d);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponseModel> getUserByUserId(@PathVariable("userId") String userId)
    {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto dto=userService.findByUserId(userId);
        if(dto==null)
        {
            throw new UserNotFoundException("no such account with id: "+userId);
        }
       UserResponseModel response=mapper.map(dto, UserResponseModel.class);
        return ResponseEntity.ok(response);
    }
}
