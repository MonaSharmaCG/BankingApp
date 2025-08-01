package com.cg.demoBank.controllers;

import com.cg.demoBank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String getIndex(){
        return "Merhaba, Spring Boot JSON örnegi!";
    }

    @GetMapping("/verify")
    public ResponseEntity<?> getVerify(@RequestParam("token")String token, @RequestParam("code")String code){

        //Get User By Token
        java.util.Optional<com.cg.demoBank.models.User> userOpt = userRepository.findByToken(token);

        //Check If Token Is Valid:
        if(!userOpt.isPresent()){
            return ResponseEntity.badRequest().body("This session has expired.");
        }

        com.cg.demoBank.models.User user = userOpt.get();
        //Check code matches
        if (!user.getCode().equals(code)) {
            return ResponseEntity.badRequest().body("Invalid verification code.");
        }

        //Update and Verify Account
        user.setVerified(1);
        user.setVerified_at(java.time.LocalDate.now());
        userRepository.save(user);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Verification success.");
        System.out.println("In Verify Account Controller");
        return ResponseEntity.ok(response);
    }
}
