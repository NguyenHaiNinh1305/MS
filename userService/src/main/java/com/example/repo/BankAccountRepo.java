package com.example.repo;

import com.example.entity.BankAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepo extends MongoRepository<BankAccount,String> {
}
