package com.gh.backend.gh.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.gh.backend.gh.model.Usuario;
import com.gh.backend.gh.repository.UsuarioRepository;

import java.util.Collections;

@Component
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;

    public DataLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (usuarioRepository.count() == 0) {
            Usuario admin = new Usuario("Admin", "admin@email.com", "123456", Collections.singleton("ROLE_ADMIN"));
            usuarioRepository.save(admin);
            System.out.println("📌 Usuário Admin criado automaticamente no MongoDB!");
        }
    }
}

