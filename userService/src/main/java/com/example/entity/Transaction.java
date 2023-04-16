package com.example.entity;

import com.example.commonservice.entity.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Transaction")
public class Transaction extends BaseEntity {
    private Long money;
    private String accountId;
    private String serviceId;
    private String receiverId;


}
