package com.reinaldosilva.questions.controller;

import com.reinaldosilva.questions.entity.Question;
import com.reinaldosilva.questions.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    //Recurso para criar uma questão com respostas
    @PostMapping
    public ResponseEntity<Question> create(@RequestBody Question question){

        Question questionEntity = questionService.create(question);
        return ResponseEntity.ok(questionEntity);

    }

    @GetMapping
    public ResponseEntity<List<Question>> getAll(){

        List<Question> questions = questionService.getAll();
        return ResponseEntity.ok(questions);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getByID(@PathVariable("id") Long id){

        Question question = questionService.findById(id);
        return ResponseEntity.ok(question);

    }

    /* @RequestMapping ("/update/{id}")
    public ResponseEntity<Question> update(@PathVariable("id") Long id){

        Question question = questionService.findById(id);
        question.update();
        return ResponseEntity.ok();

    }
    */
}
