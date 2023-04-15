package com.example.service.userServiceIpm;

import com.example.dto.UserDto;
import com.example.service.UserService;
import com.example.entity.User;
import com.example.repo.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService {

    private final UserRepository userRepository;

    public UserServiceImplement(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userRepository.save(user);
    }
}
