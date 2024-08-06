package com.trivia.model;

import java.util.Arrays;

public class QuestionDto {

    private long id;
    private String subject;
    private String question;
    private String correctAnswer;
    private String[] answers = new String[4];

    public QuestionDto() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "QuestionModel{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", question='" + question + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", answers=" + Arrays.toString(answers) +
                '}';
    }
}
