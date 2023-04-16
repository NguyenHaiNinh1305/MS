package com.example.repo;

import com.example.entity.ServiceTrans;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTransRepo extends MongoRepository<ServiceTrans,String> {
}
