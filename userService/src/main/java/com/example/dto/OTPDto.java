package com.example.dto;

import com.example.commonservice.dto.BaseDto;
import lombok.Data;

@Data
public class OTPDto extends BaseDto {
    private Integer code;
    private String bankAccountId;
}
