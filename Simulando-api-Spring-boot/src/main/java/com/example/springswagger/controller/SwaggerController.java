package com.example.springswagger.controller;

import com.example.springswagger.model.DataModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SwaggerController {

    @GetMapping("/")
    public String index() {
        return "Ola mundo, com o Spring Boot";
    }

    @GetMapping("/api")
    public List<DataModel> getAllPosts() {
        List<DataModel> posts = new ArrayList<>();

        posts.add(new DataModel(1L, "Flavo", "12"));
        posts.add(new DataModel(2L, "Gustavo", "33"));
        posts.add(new DataModel(3L, "Allerrandro", "23"));

        return posts;
    }
}
