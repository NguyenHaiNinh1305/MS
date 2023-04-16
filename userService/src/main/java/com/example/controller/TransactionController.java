package com.example.controller;

import com.example.dto.TransactionDTO;
import com.example.entity.Transaction;
import com.example.service.TransactionService;
import com.example.service.userServiceIpm.EmailServiceImpl;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    private final EmailServiceImpl emailService;

    public TransactionController(TransactionService transactionService, EmailServiceImpl emailService) {
        this.transactionService = transactionService;
        this.emailService = emailService;
    }

    @PostMapping("/")
    public void createTransaction(@RequestBody @Valid TransactionDTO transactionDTO, @Param("otp") String otp) throws Exception {
        transactionService.createTransaction(otp, transactionDTO);
    }

    @PostMapping("/sendOtp")
    public void sendOtp() throws Exception {
        emailService.sendOtp();
    }

    @GetMapping("/")
    public List<Transaction> listAllTransaction() {
        return transactionService.viewAllTransacTion();
    }
}
