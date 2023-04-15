package com.example.service;

import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.repo.UserRepository;

import java.util.Optional;

public interface UserService {

    User createUser(UserDto userDto);
    void sendTheOtp(String email);
    void singUp(User user);

}
