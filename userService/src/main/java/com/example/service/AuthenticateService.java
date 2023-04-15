package com.example.service;

import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.dto.LoginDto;
import com.example.entity.JWTTokenResponse;

public interface AuthenticateService {
    public User signup(UserDto dto);

//    ResponseObject changePassword(String username, String newPasswors, String currentpass);

//    String sendOtpToGmail(String gmail);

//    void takeNewPassword(String otpTaken, String newPassword);
    JWTTokenResponse login(LoginDto loginDto);
}
