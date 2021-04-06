package com.example.demo.service;

import com.example.demo.dto.UserDto;

public interface UserService {
    public UserDto createUser(UserDto userdto);
    public UserDto findByUserId(String userId);
    public UserDto updateUser(String userId, UserDto userDto);
}
