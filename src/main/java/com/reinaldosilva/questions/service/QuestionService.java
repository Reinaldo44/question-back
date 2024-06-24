package com.reinaldosilva.questions.service;

import com.reinaldosilva.questions.entity.Question;
import com.reinaldosilva.questions.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    public Question create(Question question){

        question.getAnswers().forEach(answer -> answer.setQuestion(question));

        return questionRepository.save(question);
    }

    @Transactional
    public List<Question> getAll() {

               return questionRepository.findAll();

               /* List<Question> randomIds = new ArrayList<>();
                Set<Integer> usedIndexes = new HashSet<>();
                List<Question> allIds = questionRepository.findAll();
                int totalIds = allIds.size();
                Random random = new Random();

                while (randomIds.size() < 4) {

                    int randomIndex = random.nextInt(totalIds);

                    if (!usedIndexes.contains(randomIndex)) {

                        Question randomId = allIds.get(randomIndex);
                        randomIds.add(randomId);
                        usedIndexes.add(randomIndex);

                    }
                }
                return randomIds;*/
            }

    public Question findById(Long id) {

        Optional<Question> questionOptional= questionRepository.findById(id);

        return questionOptional.orElseThrow();
    }


}

