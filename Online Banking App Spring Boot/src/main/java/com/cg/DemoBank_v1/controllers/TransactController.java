package com.cg.demoBank.controllers;

import com.cg.demoBank.models.User;
import com.cg.demoBank.service.PaymentService;
import com.cg.demoBank.service.AccountService;
import com.cg.demoBank.service.TransactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Map;

@Controller
@RequestMapping("/transact")
public class TransactController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private TransactService transactService;

    User user;
    String user_id;
    double currentBalance;
    double newBalance;
    LocalDateTime currentDateTime = LocalDateTime.now();

    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestBody Map<String, String> requestMap, HttpSession session) {

        String depositAmount = requestMap.get("deposit_amount");
        String accountID = requestMap.get("account_id");

        //TODO: CHECK FOR EMPTY STRINGS:
        if (depositAmount.isEmpty() || accountID.isEmpty()) {
            return ResponseEntity.badRequest().body("Deposit amount and account ID cannot be empty.");
        }
        // ...existing code...
        return ResponseEntity.ok().build(); // placeholder
    }
}
