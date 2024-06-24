package com.reinaldosilva.questions.controller;

import com.reinaldosilva.questions.entity.Feedback;
import com.reinaldosilva.questions.entity.ListAnswer;
import com.reinaldosilva.questions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/listAnswer")
public class ListAnswerController {

    @Autowired
    private UserService userService;

    @PostMapping("/{idQuestion}/respostas/{idAnswer}")
    public ListAnswer post(@PathVariable Long idQuestion, @PathVariable Long idAnswer){

        ListAnswer listAnswer = userService.saveAnswer(idQuestion, idAnswer);

        return listAnswer;

    }
    @GetMapping()
    public Feedback get(){

        return userService.analisador();

    }
}
