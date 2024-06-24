package com.reinaldosilva.questions.controller;

import com.reinaldosilva.questions.entity.User;
import com.reinaldosilva.questions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/userquestion")
public class UserQuestionController {
    @Autowired
    private UserService userService;

    //Recurso responsável por capturar se a resposta da questão está correta.
    @PostMapping
    public ResponseEntity<User> post(@RequestBody User user){

      User userCreate = userService.createUser(user);
      return ResponseEntity.ok(userCreate);
    }



}
