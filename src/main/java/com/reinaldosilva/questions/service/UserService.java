package com.reinaldosilva.questions.service;

import com.reinaldosilva.questions.entity.*;
import com.reinaldosilva.questions.repository.AnswerListRepository;
import com.reinaldosilva.questions.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AnswerListRepository answerListRepository;

    //Método para criar um user
    public User createUser(User user) {

        return userRepository.save(user);
    }

    //Método para salvar a resposta de User
    public ListAnswer saveAnswer(Long idQuestion, Long idAnswer) {

        ListAnswer listAnswer = answerListRepository.save(isAnswer(idQuestion, idAnswer));
        return listAnswer;

    }


    //método para analisar a resposta correta
    public ListAnswer isAnswer(Long idQuestion, Long idAnswer) {


        Question optionalQuestion = questionService.findById(idQuestion);

        String categoria = optionalQuestion.getCategoria().getDescricao();

        Long answerCorrect = optionalQuestion.getAnswers().stream().
                filter(p -> p.getAcerto() == true).map(Answer::getId).findFirst()
                .orElse(null);

        if (answerCorrect.equals(idAnswer)) {

            return new ListAnswer(true, categoria);

        } else {

            return new ListAnswer(false, categoria);
        }

    }

    public Feedback analisador() {

        Feedback feedback = new Feedback();

        Long categoriaFront = answerListRepository.findAll().stream().filter(p -> p.getCategoria() == "FRONTEND").count();
        Long categoriaBack = answerListRepository.findAll().stream().filter(p -> p.getCategoria() == "BACKEND").count();

        Long resultado = answerListRepository.findAll().stream().filter(p -> p.isAnswers() == true).count();

        feedback.setResultado(resultado);

        if(categoriaBack + categoriaFront == 10){

            feedback.setMessageFeedback("Parabens você acertou todas questões!");
            feedback.setLinkFeedback("teste");


        }else{
            if (categoriaFront < categoriaBack) {

                feedback.setMessageFeedback("Caro estudante você precisa estudar mais FRONTEND");
                feedback.setLinkFeedback("https://www.google.com/search?q=frontend");

            } else {
                feedback.setMessageFeedback("Caro estudante você precisa estudar mais BACKEND");
                feedback.setLinkFeedback("https://www.google.com/search?q=backend");
            }
        }


        return feedback;

    }


    public void deleteQuetionsUsers() {

        answerListRepository.deleteAll();
    }
}
