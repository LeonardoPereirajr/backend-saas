package com.gh.backend.gh.security;

import com.gh.backend.gh.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UserDetailsImpl implements UserDetails {

    private final String id;
    private final String email;
    private final String senha;
    private final Set<GrantedAuthority> authorities = new HashSet<>();

    public UserDetailsImpl(Usuario usuario) {
        this.id = usuario.getId();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        usuario.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role)));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getId() {
        return id;
    }

    @Component
    public static class JwtUtil {

        private final String SECRET_KEY = "minhaChaveSecreta";

        public String generateToken(UserDetails userDetails) {
            return Jwts.builder()
                    .setSubject(userDetails.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hora
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();
        }

        public String extractUsername(String token) {
            return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
        }

        public boolean validateToken(String token, UserDetails userDetails) {
            return extractUsername(token).equals(userDetails.getUsername()) && !isTokenExpired(token);
        }

        private boolean isTokenExpired(String token) {
            return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration().before(new Date());
        }
    }
}
