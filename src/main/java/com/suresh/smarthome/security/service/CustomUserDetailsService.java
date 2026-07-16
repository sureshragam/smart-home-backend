package com.suresh.smarthome.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.suresh.smarthome.user.entity.AppUser;
import com.suresh.smarthome.user.repository.AppUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        AppUser appUser = appUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "User not found"));

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(appUser.getEmail())
                .password(appUser.getPassword())
                .disabled(!appUser.getEnabled())
                .authorities(
                        appUser.getRoles()
                                .stream()
                                .map(role -> role.getName().name())
                                .toArray(String[]::new))
                .build();
    }
}