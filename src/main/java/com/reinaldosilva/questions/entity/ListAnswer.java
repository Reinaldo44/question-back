package com.reinaldosilva.questions.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "user-list")
public class ListAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean answers;
    private String categoria;

    public ListAnswer(boolean answer, String categoria) {

        this.answers = answer;
        this.categoria = categoria;
    }

    public ListAnswer() {
    }

    public void setAnswers(boolean answers) {
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public boolean isAnswers() {
        return answers;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
