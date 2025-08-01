package com.cg.demoBank.controllers;

import com.cg.demoBank.helpers.GenAccountNumber;
import com.cg.demoBank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cg.demoBank.models.User;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create_account")
    public ResponseEntity<?> createAccount(@RequestBody Map<String, String> requestMap, HttpSession session){
        System.out.println("[AccountController] Incoming createAccount request: " + requestMap);
        String accountName = requestMap.get("account_name");
        String accountType = requestMap.get("account_type");

        // Robust null and empty check
        if(accountName == null || accountType == null || accountName.trim().isEmpty() || accountType.trim().isEmpty()){
            System.out.println("[AccountController] account_name or account_type is empty or null");
            return ResponseEntity.badRequest().body("Account name and type cannot be empty!");
        }

        // Get logged in user
        User user = (User) session.getAttribute("user");
        System.out.println("[AccountController] Session user: " + user);
        if(user == null || user.getUser_id() == null || user.getUser_id().isEmpty()) {
            System.out.println("[AccountController] User not logged in or user_id missing");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You must login first or user_id missing."); // 401 Unauthorized
        }

        String user_id = user.getUser_id();

        // Generate a unique account number as a String
        String bankAccountNumber = String.valueOf(GenAccountNumber.generateAccountNumber());
        // ...existing code...
        return ResponseEntity.ok().build(); // placeholder
    }
}
