package com.reinaldosilva.questions.entity;

public enum Categoria {

    Backend("BACKEND"),
    Frontend("FRONTEND")
    ;
    private String descricao;
    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

}
