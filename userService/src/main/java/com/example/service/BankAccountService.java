package com.example.service;

import com.example.dto.BankAccountDTO;
import com.example.dto.ServiceTransDTO;
import com.example.entity.BankAccount;
import com.example.entity.ServiceTrans;
import com.example.repo.BankAccountRepo;
import com.example.repo.ServiceTransRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {
    @Autowired
    private  BankAccountRepo bankAccountRepo;






    public BankAccount createService (BankAccountDTO bDto){
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(bDto, bankAccount);
        bankAccountRepo.save(bankAccount);
        return  bankAccount;
    }
}
