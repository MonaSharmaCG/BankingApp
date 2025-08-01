package com.cg.demoBank.repository;

import com.cg.demoBank.models.PaymentHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PaymentHistoryRepository extends MongoRepository<PaymentHistory, String> {
    List<PaymentHistory> findByAccountId(String accountId);
    // Add more MongoDB query methods as needed
}
