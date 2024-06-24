package com.reinaldosilva.questions.repository;

import com.reinaldosilva.questions.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
