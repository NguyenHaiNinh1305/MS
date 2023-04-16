package com.example.repo;

import com.example.entity.OTP;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OTPRepo extends MongoRepository<OTP,String> {

    Optional<OTP> findByCode(String s);
}
