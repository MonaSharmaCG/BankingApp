package com.cg.demoBank.controllers;

import com.cg.demoBank.models.Account;
import com.cg.demoBank.models.User;
import com.cg.demoBank.repository.AccountRepository;
import com.cg.demoBank.repository.PaymentHistoryRepository;
import com.cg.demoBank.repository.TransactHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/app")
public class AppController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;

    @Autowired
    private TransactHistoryRepository transactHistoryRepository;

    User user;
    @GetMapping("/dashboard")
    public ResponseEntity<?> getDashboard(HttpSession session){
        //Get the details of the logged in user:
        user = (User) session.getAttribute("user");
        if (user == null || user.getUser_id() == null || user.getUser_id().isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in or user_id missing.");
        }
        String userId = user.getUser_id();
        //Get The Accounts of The Logged In User:
        List<Account> getUserAccounts = accountRepository.findByUserId(userId);
        // ...existing code...
        return ResponseEntity.ok().build(); // placeholder
    }
}
