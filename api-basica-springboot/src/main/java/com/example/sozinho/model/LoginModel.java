package com.example.sozinho.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class LoginModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String senha;

    public LoginModel() {

    }

    public int getId() {
        return Math.toIntExact(id);
    }

    public void setId(int id) {
        this.id = (long) id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
