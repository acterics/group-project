package com.groupproject.userservice.service;

import com.groupproject.userservice.domain.User;
import com.groupproject.userservice.mapper.UserResponseMapper;
import com.groupproject.userservice.model.response.UserResponse;
import com.groupproject.userservice.repository.UserRepository;
import com.thoughtworks.xstream.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rick on 03.12.17.
 */

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserResponseMapper userResponseMapper;

    @Autowired
    public UserService(UserRepository userRepository,
                       UserResponseMapper userResponseMapper) {
        this.userResponseMapper = userResponseMapper;
        this.userRepository = userRepository;
    }

    public UserResponse getUserById(Long id) {
        User response = userRepository.findOne(id);
        if (response == null) {
            UserResponse userResponse = new UserResponse();
            userResponse.setMessage("Cannot find User by provided id: " + id);
            return userResponse;
        }
        return userResponseMapper.map(response);
    }
}
