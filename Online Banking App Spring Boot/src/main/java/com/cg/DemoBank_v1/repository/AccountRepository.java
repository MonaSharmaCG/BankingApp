package com.cg.demoBank.repository;

import com.cg.demoBank.models.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface AccountRepository extends MongoRepository<Account, String> {
    List<Account> findByUserId(String userId);
    Account findByUserIdAndAccountId(String userId, String accountId);
    // Add more MongoDB query methods as needed
}
