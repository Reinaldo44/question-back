package com.reinaldosilva.questions.entity;

public class Feedback {

    private Long resultado;

    private String LinkFeedback;

    private String MessageFeedback;

    public Feedback(Long resultado, String linkFeedback, String messageFeedback) {
        this.resultado = resultado;
        LinkFeedback = linkFeedback;
        MessageFeedback = messageFeedback;
    }

    public Feedback() {
    }

    public Long getResultado() {
        return resultado;
    }

    public String getLinkFeedback() {
        return LinkFeedback;
    }

    public String getMessageFeedback() {
        return MessageFeedback;
    }

    public void setResultado(Long resultado) {
        this.resultado = resultado;
    }

    public void setLinkFeedback(String linkFeedback) {
        LinkFeedback = linkFeedback;
    }

    public void setMessageFeedback(String messageFeedback) {
        MessageFeedback = messageFeedback;
    }
}
