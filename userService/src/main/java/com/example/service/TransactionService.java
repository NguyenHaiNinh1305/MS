package com.example.service;

import com.example.dto.TransactionDTO;
import com.example.entity.BankAccount;
import com.example.entity.Transaction;
import com.example.repo.BankAccountRepo;
import com.example.repo.TransactionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private BankAccountRepo bankAccountRepo;

    @Autowired
    private OTPService otpService;

//    public void sendOtp () throws Exception {
//        RedisTemplate<String, String> redisTemplate = createRedisTemplate();
//        OTPService otpService = new OTPService(redisTemplate);
//
//        String otpKey = "user123";
//        String otpValue = generateOtp();
//
//        otpService.storeOtp(otpKey, otpValue);
//
//        // Wait for 30 seconds
//        try {
//            Thread.sleep(30000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        otpService.isOtpExpired(otpKey, otpKey, otpValue);
//    }

    public Transaction createTransaction(String otp, TransactionDTO tDto) throws Exception {
//        RedisTemplate<String, String> redisTemplate = createRedisTemplate();

//        String otpValue = redisTemplate.opsForValue().get("user123");

        if (otpService.verify(otp)) {
            Transaction transaction = new Transaction();
            BeanUtils.copyProperties(tDto, transaction);
            transactionRepository.save(transaction);
            updateBankAccountById(tDto);
            return transaction;
      }
//        return null;

        return null;
    }
        public void updateBankAccountById (TransactionDTO transactionDTO) throws Exception {
            String id1 = transactionDTO.getAccountId();
            BankAccount bankAccount1 = bankAccountRepo.findById(id1).orElse(null);
            bankAccount1.minus(transactionDTO.getMoney());
            String id2 = transactionDTO.getReceiverId();
            BankAccount bankAccount2 = bankAccountRepo.findById(id2).orElse(null);
            bankAccount2.addMoney(transactionDTO.getMoney());
        }

        public List<Transaction> viewAllTransacTion () {
            List<Transaction> transactionList = transactionRepository.findAll();
            return transactionList;
        }

//        private static RedisTemplate<String, String> createRedisTemplate () {
//            // Configure RedisTemplate
//            RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
//            redisTemplate.setConnectionFactory(new LettuceConnectionFactory());
//            redisTemplate.setKeySerializer(new StringRedisSerializer());
//            redisTemplate.setValueSerializer(new StringRedisSerializer());
//            redisTemplate.afterPropertiesSet();
//            return redisTemplate;
//        }

        public String generateOtp () {
            Random random = new Random();
            Integer otp = 100000 + random.nextInt(999999);

            return String.valueOf(otp);
        }

}
