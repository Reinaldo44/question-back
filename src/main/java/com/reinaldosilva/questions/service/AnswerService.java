package com.reinaldosilva.questions.service;

import com.reinaldosilva.questions.entity.Answer;
import com.reinaldosilva.questions.repository.AnswerRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public Answer create(Answer answer){

        return answerRepository.save(answer);

    }
    public List<Answer> findAll() {

        return answerRepository.findAll();

    }
    public Answer remove(Answer answer){

        Optional<Answer> answerEntity = answerRepository.findById(answer.getId());

        if(answerEntity.isPresent()){

            answerRepository.delete(answer);

        }

        return answer;
    }

}
