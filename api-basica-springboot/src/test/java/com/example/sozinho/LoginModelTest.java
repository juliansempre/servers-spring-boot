package com.example.sozinho;

import com.example.sozinho.model.LoginModel;
import jakarta.persistence.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

@Entity
@Table(name = "usuarios")
public class LoginModelTest {
    @InjectMocks
    private LoginModel loginModel;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String senha;

    public LoginModelTest(int id, String nome, String senha) {
        this.id = (long) id;
        this.nome = nome;
        this.senha = senha;
    }
    @Test
    public int getId() {
        return Math.toIntExact(id);
    }
    @Test
    public void setId(int id) {
        this.id = (long) id;
    }
    @Test
    public String getNome() {
        return nome;
    }
    @Test
    public void setNome(String nome) {
        this.nome = nome;
    }
    @Test
    public String getSenha() {
        return senha;
    }
    @Test
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
