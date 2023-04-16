package com.example.entity;

import com.example.commonservice.entity.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "BankAccount")
public class BankAccount extends BaseEntity {
    private Long totalMoney;
    private AccountType accountType;
    private String bankName;
    private String activeDate;
    private String expiredDate;
    private String userId;

public Long addMoney (Long added){
    this.totalMoney+=added;
    return this.totalMoney;
}
public Long minus(Long minus) throws Exception {
    if(this.totalMoney<minus){
        throw new Exception("Not enough money to transfer");
    }
    this.totalMoney-=minus;
    return this.totalMoney;
}
}
