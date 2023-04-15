package com.example.utils;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SecurityUtil {

    private SecurityUtil() {

    }

    public static Optional<String> getCurrentUserLogin() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication()).map(authentication -> {
            if (authentication.getPrincipal() instanceof UserDetails) {
                UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
                return springSecurityUser.getUsername();
            } else if (authentication.getPrincipal() instanceof String) {
                return (String) authentication.getPrincipal();
            }
            return null;
        });
    }

    // get user fỏm jwt
    public static Optional<String> getCurrentUserJWT() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication()).filter(authentication
                -> authentication.getCredentials() instanceof String).map(authentication
                -> (String) authentication.getCredentials());
    }

    public static boolean isAuthenticated() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication()).map(authentication -> {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.addAll(authentication.getAuthorities());
            return authorities.stream().noneMatch(grantedAuthority
                    -> grantedAuthority.getAuthority().equals("EMPLOYEE"));
        }).orElse(false);
    }

    public static boolean isCurrentUserInRole(String authority) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication()).map(authentication -> {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.addAll(authentication.getAuthorities());
            return authorities.stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(authority));
        }).orElse(false);
    }
}
