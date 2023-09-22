package com.example.sozinho.service;

import com.example.sozinho.model.LoginModel;
import com.example.sozinho.repository.SozinhoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@AllArgsConstructor
public class SozinhoService {
 private final SozinhoRepository sozinhoRepository;
 public List<LoginModel> listAllTasks(){

  return sozinhoRepository.findAll();
 }
 public LoginModel createApp (LoginModel loginModel) {
     return sozinhoRepository.save(loginModel);
 }

 public ResponseEntity<LoginModel> findAppById(Long id){
  return  sozinhoRepository.findById(id)
          .map(task -> ResponseEntity.ok().body(task))
          .orElse(ResponseEntity.notFound().build());
 }

 public ResponseEntity<LoginModel> updateAppById(LoginModel loginModel, Long id){
  return sozinhoRepository.findById(id)
          .map(taskToUpdate ->{
           taskToUpdate.setNome(loginModel.getNome());
           taskToUpdate.setSenha(loginModel.getSenha());
           LoginModel updated = sozinhoRepository.save(taskToUpdate);
           return ResponseEntity.ok().body(updated);
          }).orElse(ResponseEntity.notFound().build());
 }

 public ResponseEntity<Object> deleteAppById (Long id){
  return sozinhoRepository.findById(id)
          .map(taskToDelete ->{
           sozinhoRepository.deleteById(id);
           return ResponseEntity.noContent().build();
          }).orElse(ResponseEntity.notFound().build());

 }
}
