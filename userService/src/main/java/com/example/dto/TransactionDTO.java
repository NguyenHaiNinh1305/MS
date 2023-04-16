package com.example.dto;

import com.example.commonservice.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO extends BaseDto {
    private Long money;
    private String accountId;
    private String serviceId;
    private String receiverId;
}
