package com.example.service.userServiceIpm;

import com.example.dto.UserDto;
import com.example.service.UserService;
import com.example.entity.User;
import com.example.repo.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
public class UserServiceImplement implements UserService {

    private final UserRepository userRepository;
    private final JavaMailSender mailSender;

    private final Map<String, Integer> otpMap;
    public UserServiceImplement(UserRepository userRepository, JavaMailSender mailSender) {

        this.userRepository = userRepository;
        this.mailSender = mailSender;
        otpMap=   new HashMap<>();

    }

    @Override
    public User createUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userRepository.save(user);
        return  user;
    }

    @Override
    public void singUp(User user) {

    }
    public void sendTheOtp(String email) {
        String otp = generateOtp();
        sendOtpEmail(email, otp);
        otpMap.put(email, Integer.valueOf(otp));
        new Thread(() -> {
            try {
                Thread.sleep(60_000);
                otpMap.remove(email);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public boolean verifyOtp(String email, int otp) {
        if (otpMap.containsKey(email) && otpMap.get(email) == otp) {
            otpMap.remove(email);
            return true;
        }
        return false;
    }

    private String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return Integer.toString(otp);
    }

    private void sendOtpEmail(String email, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("OTP for email verification");
        message.setText("Your OTP is: " + otp);
        mailSender.send(message);
    }

}
