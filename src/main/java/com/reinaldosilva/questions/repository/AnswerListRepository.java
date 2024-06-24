package com.reinaldosilva.questions.repository;

import com.reinaldosilva.questions.entity.ListAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerListRepository extends JpaRepository<ListAnswer, Long> {


}
