package com.gh.backend.gh.security;

import com.gh.backend.gh.model.Usuario;
import com.gh.backend.gh.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);

        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuário não encontrado com o email: " + email);
        }

        return new UserDetailsImpl(usuario.get());
    }
}