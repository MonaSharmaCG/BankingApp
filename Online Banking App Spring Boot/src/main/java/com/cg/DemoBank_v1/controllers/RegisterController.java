package com.cg.demoBank.controllers;

// import com.cg.DemoBank_v1.helpers.HTML;
import com.cg.demoBank.helpers.Token;
// import com.cg.DemoBank_v1.mailMessenger.MailMessenger;
import com.cg.demoBank.models.User;
import com.cg.demoBank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.RestController;

// import javax.mail.MessagingException;

import javax.annotation.PostConstruct;

@RestController
public class RegisterController {
    private final UserRepository userRepository;

    @Autowired
    public RegisterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Default test user credentials
    private static final String DEFAULT_EMAIL = "testuser@demo.com";
    private static final String DEFAULT_PASSWORD = "Test@1234";

    @PostConstruct
    public void insertDefaultTestUser() {
        if (!userRepository.findByEmail(DEFAULT_EMAIL).isPresent()) {
            User testUser = new User();
            testUser.setFirst_name("Test");
            testUser.setLast_name("User");
            testUser.setEmail(DEFAULT_EMAIL);
            testUser.setPassword(BCrypt.hashpw(DEFAULT_PASSWORD, BCrypt.gensalt()));
            testUser.setToken(Token.generateToken());
            testUser.setCode("0000");
            testUser.setVerified(1); // auto-verified
            userRepository.save(testUser);
        }
    }
    // ...existing code...
}
