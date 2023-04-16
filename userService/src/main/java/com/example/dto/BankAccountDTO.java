package com.example.dto;

import com.example.commonservice.dto.BaseDto;
import com.example.entity.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDTO extends BaseDto {
    private Long totalMoney;
    private AccountType accountType;
    private String bankName;
    private String activeDate;
    private String expiredDate;
    private String userId;
}
