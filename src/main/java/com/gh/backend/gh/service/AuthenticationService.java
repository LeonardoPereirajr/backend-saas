package com.gh.backend.gh.service;

import com.gh.backend.gh.dto.LoginRequest;
import com.gh.backend.gh.security.UserDetailsImpl;
import com.gh.backend.gh.security.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UserDetailsImpl.JwtUtil jwtUtil;

    public String authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        return jwtUtil.generateToken(userDetails);
    }

    public void logout(HttpServletRequest request) {
        // Apenas remove o token do lado do cliente. No backend, JWT não exige remoção, pois expira automaticamente.
    }
}

