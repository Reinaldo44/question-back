package com.reinaldosilva.questions.controller;

import com.reinaldosilva.questions.entity.Answer;
import com.reinaldosilva.questions.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    private AnswerService serviceAnswer;

    @PostMapping
    public ResponseEntity<Answer> create(@RequestBody Answer answer){

        Answer answerEntity = serviceAnswer.create(answer);
        return ResponseEntity.ok(answerEntity);
    }

    @GetMapping
    public ResponseEntity<List<Answer>> findAll(){

        return ResponseEntity.ok(serviceAnswer.findAll());
    }

    @DeleteMapping
    public ResponseEntity<Answer> delete(Answer answer){

        Answer answer1 = serviceAnswer.remove(answer);
        return ResponseEntity.ok(answer1);
    }



}
