package com.example.service.userServiceIpm;

import com.example.config.security.UserPrincipal;
import com.example.entity.User;
import com.example.repo.UserRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component("userDetailService")
public class UserDetailServiceImplement implements UserDetailsService {

    public final UserRepository userRepository;

    public UserDetailServiceImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("username not found");
        }
        List<GrantedAuthority> grantedAuthorities
                =  user.getRoles().stream().map(auth -> new SimpleGrantedAuthority(auth)).collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassWord(), grantedAuthorities);
    }

    @Transactional
    public UserDetails loadUserByEmail(String email)
            throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with email : " + email)
                );
        return UserPrincipal.create(user);
    }
}
