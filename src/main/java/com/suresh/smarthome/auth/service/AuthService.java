package com.suresh.smarthome.auth.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.suresh.smarthome.auth.dto.request.LoginRequest;
import com.suresh.smarthome.auth.dto.request.RegisterRequest;
import com.suresh.smarthome.auth.dto.response.RegisterResponse;
import com.suresh.smarthome.common.exception.ResourceNotFoundException;
import com.suresh.smarthome.security.jwt.JwtService;
import com.suresh.smarthome.security.service.CustomUserDetailsService;
import com.suresh.smarthome.user.entity.AppUser;
import com.suresh.smarthome.user.entity.Role;
import com.suresh.smarthome.user.enums.RoleType;
import com.suresh.smarthome.user.repository.AppUserRepository;
import com.suresh.smarthome.user.repository.RoleRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.transaction.annotation.Transactional;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;

    private final CustomUserDetailsService customUserDetailsService;

    private final JwtService jwtService;
    
    private final AppUserRepository appUserRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    @Value("${jwt.expiration}")
    private int expiration;

    public String login(LoginRequest request, HttpServletResponse response) {

    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()));

    UserDetails user =
            customUserDetailsService.loadUserByUsername(
                    request.getEmail());

    String token = jwtService.generateToken(user);

    ResponseCookie cookie = ResponseCookie.from("access_token", token)
            .httpOnly(true)
            .secure(true)
            .sameSite("None")
            .path("/")
            .maxAge(expiration)
            .build();

    response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());

    return "Login Successful";
}
    
    @Transactional
    public RegisterResponse register(RegisterRequest request) {

        if (appUserRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists.");
        }

        Role role = roleRepository.findByName(RoleType.ROLE_ADMIN)
                .orElseThrow(() ->
                        new ResourceNotFoundException("ROLE_ADMIN not found."));

        AppUser user = AppUser.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .enabled(true)
                .roles(Set.of(role))
                .build();

        appUserRepository.save(user);

        return RegisterResponse.builder()
                .message("User registered successfully.")
                .build();
    }
    
    public String logout(HttpServletResponse response) {

    ResponseCookie cookie = ResponseCookie.from("access_token", "")
            .httpOnly(true)
            .secure(true)
            .sameSite("None")
            .path("/")
            .maxAge(0)
            .build();

    response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());

    return "Logout Successful";
}

}