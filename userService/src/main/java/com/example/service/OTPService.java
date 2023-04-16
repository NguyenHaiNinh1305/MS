package com.example.service;

import com.example.entity.OTP;
import com.example.repo.OTPRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OTPService {
    @Autowired
    private OTPRepo otpRepo;

//    private final RedisTemplate<String, String> redisTemplate;

//    public OTPService(RedisTemplate<String, String> redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }

//    public boolean isOtpExpired(String otpKey, String to, String otpValue ) {
//        Long ttl = redisTemplate.getExpire(otpKey);
//        sendOtp(to, otpValue);
//        return ttl != null && ttl < 0;
//    }

//    public void storeOtp(String otpKey, String otpValue) {
//        redisTemplate.opsForValue().set(otpKey, String.valueOf(otpValue), 60, TimeUnit.SECONDS);
//    }
//
//    public boolean verifyOtp(String otpKey, String otpValue) {
//        // Get the stored OTP from Redis
//        String storedOtp = redisTemplate.opsForValue().get(otpKey);
//
//        // Check if the stored OTP matches the provided OTP
//        if (storedOtp != null && storedOtp.equals(otpValue)) {
//            // If the OTP is valid, remove it from Redis
//            redisTemplate.delete(otpKey);
//            return true;
//        } else {
//            // If the OTP is not valid, return false
//            return false;
//        }
//    }


    public boolean verify(String otp) {
        OTP otps = otpRepo.findByCode(otp).orElse(null);
        if (otps != null) {
            otpRepo.delete(otps);
            return true;
        }


        return false;
    }


}
