package com.cg.demoBank.repository;

import com.cg.demoBank.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
    Optional<User> findByTokenAndCode(String token, String code);
    Optional<User> findByToken(String token);
    // Add more MongoDB query methods as needed
}
