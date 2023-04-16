package com.example.service.userServiceIpm;

import com.example.entity.OTP;
import com.example.repo.OTPRepo;
import com.example.service.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@Service
public class EmailServiceImpl  {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private OTPRepo otpRepo;

    @Value("${spring.mail.username}")
    private String from;


    public void sendOtp() {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        String otp = generateOtp();
        OTP otpObj = new OTP();
        otpObj.setCode(otp);
        otpRepo.save(otpObj);
        try {
            helper.setFrom(from);
            helper.setTo(from);
            helper.setSubject("OTP for verification");
            helper.setText("Your OTP is: " + otp);
            javaMailSender.send(message);
            Thread.sleep(60000);
            otpRepo.delete(otpObj);


        } catch (MessagingException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sendOtpS(String email) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        String otp = generateOtp();
        OTP otpObj = new OTP();
        otpObj.setCode(otp);
        otpRepo.save(otpObj);
        try {
            helper.setFrom(from);
            helper.setTo(email);
            helper.setSubject("OTP for verification");
            helper.setText("Your OTP is: " + otp);
            javaMailSender.send(message);
            Thread.sleep(60000);
            otpRepo.delete(otpObj);


        } catch (MessagingException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String generateOtp() {
        Random random = new Random();
        Integer otp = 100000 + random.nextInt(999999);

        return otp.toString();
    }
}
