package com.cg.demoBank.interceptors;

import com.cg.demoBank.exception.CustomError;
import com.cg.demoBank.helpers.authorization.JwtService;
import com.cg.demoBank.repository.UserRepository;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AppInterceptor implements HandlerInterceptor{
    public UserRepository userRepository;

    @Autowired
    public AppInterceptor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private JwtService jwtService = new JwtService();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException, CustomError {
        System.out.println("In Pre Handle Interceptor Method");
        if(request.getRequestURI().startsWith("/app") || request.getRequestURI().startsWith("/transact") || request.getRequestURI().startsWith("/logout") || request.getRequestURI().startsWith("/account")){
            String header = request.getHeader("Authorization");
            if(jwtService.isTokenIncluded(header)==false)
                throw new CustomError("You need to be logged in.",HttpServletResponse.SC_UNAUTHORIZED);
            System.out.println("Hereee is theeeeeeeeeeeeeeeeeee header: "+ header);
            String token = jwtService.getAccessTokenFromHeader(header);
            System.out.println("Jwt from logout: " + token);
            Claims claims = jwtService.decodeToken(token);
            if (claims == null) {
                throw new CustomError("Token is not valid.", HttpServletResponse.SC_UNAUTHORIZED);
            }
            String email = claims.getSubject();
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // ...existing code...
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // ...existing code...
    }
}
