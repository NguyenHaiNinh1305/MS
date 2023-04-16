package com.example.controller;

import com.example.Mapping.UserMapper;
import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.repo.UserRepository;
import com.example.service.UserService;
import com.example.dto.LoginDto;
import com.example.service.AuthenticateService;
import com.example.service.userServiceIpm.EmailServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Random;

@RestController
@RequestMapping(value = "api/v1/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticateController {


    private final UserService userService;


    private EmailServiceImpl emailService;
    private final AuthenticateService authenticateService;
private UserRepository userRepository;

    public AuthenticateController(UserService userService, AuthenticateService authenticateService, EmailServiceImpl em,UserRepository userRepository) {
        this.userService = userService;
        this.authenticateService = authenticateService;
       this.emailService=em;
this.userRepository=userRepository;
    }


    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody UserDto dto) {
        User user = userRepository.findByEmail(dto.getEmail()).orElse(null);
        if (user != null) {
            return ResponseEntity.badRequest().body("Email already exists");
        }
        User user1= userService.createUser(dto);

        String otp = generateOTP();

        user1.setDto(otp);


        // Use a separate thread to send the email
        new Thread(() -> {
            emailService.sendOtpS( user1.getEmail());
        }).start();


        return ResponseEntity.ok("User registered successfully. Please verify your email.");
    }
    private String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return Integer.toString(otp);
    }
    /*
    Login api
     */
    @PostMapping("/login")
    public ResponseEntity<?> authenticateAdmin(@Valid @RequestBody LoginDto loginDto) {
        return ResponseEntity.ok().body(authenticateService.login(loginDto));
    }
}
