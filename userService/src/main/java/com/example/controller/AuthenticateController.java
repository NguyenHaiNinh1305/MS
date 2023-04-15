package com.example.controller;

import com.example.dto.UserDto;
import com.example.service.UserService;
import com.example.dto.LoginDto;
import com.example.service.AuthenticateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "api/v1/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticateController {


    private final UserService userService;
    private final AuthenticateService authenticateService;


    public AuthenticateController(UserService userService, AuthenticateService authenticateService) {
        this.userService = userService;
        this.authenticateService = authenticateService;
    }


    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody UserDto dto) {


        return ResponseEntity.ok().body("ok");
    }

    /*
    Login api
     */
    @PostMapping("/login")
    public ResponseEntity<?> authenticateAdmin(@Valid @RequestBody LoginDto loginDto) {
        return ResponseEntity.ok().body(authenticateService.login(loginDto));
    }
}
