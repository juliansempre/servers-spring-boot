package com.example.sozinho.repository;

import com.example.sozinho.model.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SozinhoRepository extends JpaRepository<LoginModel, Long> {
}