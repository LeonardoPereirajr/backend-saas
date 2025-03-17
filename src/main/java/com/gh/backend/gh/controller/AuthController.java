package com.gh.backend.gh.controller;

import com.gh.backend.gh.dto.LoginRequest;
import com.gh.backend.gh.model.Usuario;
import com.gh.backend.gh.repository.UsuarioRepository;
import com.gh.backend.gh.security.JwtUtils;
import com.gh.backend.gh.service.JwtService;
import com.gh.backend.gh.service.UserDetailsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UsuarioRepository usuarioRepository;
    private final UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils,
                          UsuarioRepository usuarioRepository, UserDetailsServiceImpl userDetailsService,
                          PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.usuarioRepository = usuarioRepository;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        System.out.println("Recebendo login: " + loginRequest.getEmail() + " / " + loginRequest.getSenha());

        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(loginRequest.getEmail());

        if (usuarioOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Usuário ou senha inválidos!"));
        }

        Usuario usuario = usuarioOptional.get();

        if (!passwordEncoder.matches(loginRequest.getSenha(), usuario.getSenha())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Usuário ou senha inválidos!"));
        }

        String jwt = jwtService.generateToken(usuario.getEmail());

        return ResponseEntity.ok(Map.of("token", jwt));
    }



    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuario usuario) {
        Optional<Usuario> existingUser = usuarioRepository.findByEmail(usuario.getEmail());
        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().body("Erro: Usuário já existe!");
        }

        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }
}
