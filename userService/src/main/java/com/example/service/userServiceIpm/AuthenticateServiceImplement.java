package com.example.service.userServiceIpm;

import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.repo.UserRepository;
import com.example.service.AuthenticateService;
import com.example.config.security.JWTFilter;
import com.example.config.security.TokenProvider;
import com.example.dto.LoginDto;
import com.example.entity.JWTTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateServiceImplement implements AuthenticateService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    TokenProvider tokenProvider;
    @Override
    public User signup(UserDto dto) {
        return null;
    }

    public JWTTokenResponse login(LoginDto loginDto) {
        UsernamePasswordAuthenticationToken authenticationString = new UsernamePasswordAuthenticationToken(
                loginDto.getUserName(),
                loginDto.getPassWord()
        );
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationString);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication, false);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, String.format("Bearer %s", jwt));
        return new JWTTokenResponse(jwt);
    }
}
