package com.project.model;

public class question {
    private Integer id;

    private String question;

    private String answer;

    private Integer statusint;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getStatusint() {
        return statusint;
    }

    public void setStatusint(Integer statusint) {
        this.statusint = statusint;
    }
}