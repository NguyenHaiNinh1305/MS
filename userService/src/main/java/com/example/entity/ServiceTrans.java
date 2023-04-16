package com.example.entity;

import com.example.commonservice.entity.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Service")
public class ServiceTrans extends BaseEntity {
  private   String serviceName;
  private  String serviceType;
  private Integer frequency;
}
