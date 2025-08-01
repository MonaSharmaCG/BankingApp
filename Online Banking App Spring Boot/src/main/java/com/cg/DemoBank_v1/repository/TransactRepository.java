package com.cg.demoBank.repository;

import com.cg.demoBank.models.Transact;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface TransactRepository extends MongoRepository<Transact, String> {
    List<Transact> findByAccountId(String accountId);
    // Add more MongoDB query methods as needed
}
