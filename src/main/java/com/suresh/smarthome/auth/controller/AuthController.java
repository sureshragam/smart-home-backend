package com.suresh.smarthome.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.suresh.smarthome.auth.dto.request.LoginRequest;
import com.suresh.smarthome.auth.dto.request.RegisterRequest;
import com.suresh.smarthome.auth.dto.response.AuthMeResponse;
import com.suresh.smarthome.auth.dto.response.RegisterResponse;
import com.suresh.smarthome.auth.service.AuthService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @Valid @RequestBody LoginRequest request,HttpServletResponse response) {

        return ResponseEntity.ok(
                authService.login(request,response));
    }
    
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(
            @Valid @RequestBody RegisterRequest request) {

        return ResponseEntity.ok(
                authService.register(request));
    }
    
    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpServletResponse response){
    	return ResponseEntity.ok(authService.logout(response));
    }
    
    @GetMapping("/me")
    public ResponseEntity<AuthMeResponse> me(Authentication authentication) {

        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(401).build();
        }

        String role = authentication.getAuthorities()
                .stream()
                .findFirst()
                .map(authority -> authority.getAuthority())
                .orElse("");

        AuthMeResponse response = AuthMeResponse.builder()
                .username(authentication.getName())
                .role(role)
                .build();

        return ResponseEntity.ok(response);
    }

}