package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.UserModel;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public UserDto createUser(UserDto userDto) {
        // TODO Auto-generated method stub
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserModel model = mapper.map(userDto, UserModel.class);
        userRepository.save(model);
        UserDto dto= mapper.map(model, UserDto.class);
        return dto;
    }
    @Override
    public UserDto findByUserId(String userId) {
        // TODO Auto-generated method stub
            ModelMapper mapper = new ModelMapper();
            mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            UserModel model=userRepository.findByUserId(userId);
            if(model==null)
            {
                return null;
            }
            else
            {
                UserDto dto=mapper.map(model,UserDto.class);
                return dto;
            }

    }
    @Override
    @Transactional
    public UserDto updateUser(String userId, UserDto userDto) {
       UserModel userModel = userRepository.findByUserId(userId);
        if(userModel==null){
            throw new UserNotFoundException("Account not found..");
        }
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserModel model=mapper.map(userDto,UserModel.class);
        userModel.setFirstName(model.getFirstName());
       userModel.setLastName(model.getLastName());
        userModel.setEmail(model.getEmail());
        userRepository.save(userModel);
       UserDto accDto=mapper.map(userModel,UserDto.class);
        return accDto;

    }
}
