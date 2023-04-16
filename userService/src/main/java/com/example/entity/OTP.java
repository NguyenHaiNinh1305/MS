package com.example.entity;

import com.example.commonservice.entity.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Random;

@Data
@Document(collection = "OTP")
public class OTP extends BaseEntity {
    private String code;
    private String bankAccountId;
    private Date expiredTime;



//    public  String getCode (){
//        this.code=generateOtp();
//        return this.code;
//    }


}
