package com.cg.demoBank.repository;

import com.cg.demoBank.models.TransactionHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface TransactHistoryRepository extends MongoRepository<TransactionHistory, String> {
    List<TransactionHistory> findByAccountId(String accountId);
    // Add more MongoDB query methods as needed
}
