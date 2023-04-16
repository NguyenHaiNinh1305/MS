package com.example.dto;

import com.example.commonservice.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceTransDTO extends BaseDto {
    private   String serviceName;
    private  String serviceType;
    private Integer frequency;
}
