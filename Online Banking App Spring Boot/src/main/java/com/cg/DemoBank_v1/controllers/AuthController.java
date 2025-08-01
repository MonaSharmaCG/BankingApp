package com.cg.demoBank.controllers;

import com.cg.demoBank.helpers.authorization.JwtService;
import com.cg.demoBank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class AuthController {

    private UserRepository userRepository;
    public JwtService jwtService;

    @Autowired
    public AuthController(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> requestMap ,
                                   HttpSession session, HttpServletResponse response){

        String email = requestMap.get("email");
        String password = requestMap.get("password");
        // ...existing code...
        return ResponseEntity.ok().build(); // placeholder
    }
}
