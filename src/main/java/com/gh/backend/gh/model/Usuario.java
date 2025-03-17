package com.gh.backend.gh.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "usuarios")
public class Usuario {

    @Id
    private String id;

    private String nome;
    private String email;
    private String senha;
    private Set<String> roles = new HashSet<>();

    // Construtor vazio para o Spring
    public Usuario() {}

    // Construtor para inicialização rápida
    public Usuario(String nome, String email, String senha, Set<String> roles) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.roles = roles;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}
