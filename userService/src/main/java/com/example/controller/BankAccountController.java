package com.example.controller;

import com.example.dto.BankAccountDTO;
import com.example.dto.ServiceTransDTO;
import com.example.service.BankAccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/bankaccount")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }


    @PostMapping()
    public void createBankAccount(@RequestBody @Valid BankAccountDTO bankAccountDTO){
        bankAccountService.createService(bankAccountDTO);

    }
}
