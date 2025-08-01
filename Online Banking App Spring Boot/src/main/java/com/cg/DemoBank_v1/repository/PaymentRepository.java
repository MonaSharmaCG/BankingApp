package com.cg.demoBank.repository;

import com.cg.demoBank.models.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PaymentRepository extends MongoRepository<Payment, String> {
    List<Payment> findByAccountId(int accountId);
    // Add more MongoDB query methods as needed
}
