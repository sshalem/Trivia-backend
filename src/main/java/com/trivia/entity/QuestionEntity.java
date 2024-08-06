package com.trivia.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "QUESTION_TB")
public class QuestionEntity {

    @Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "userseq", initialValue = 11, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userseq")
    private long id;
    private String subject;
    private String question;
    private String correctAnswer;
    private String answers;

    public QuestionEntity() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
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

    @Override
    public String toString() {
        return "QuestionEntity [id=" + id + ", subject=" + subject + ", question=" + question + ", answers="
                + answers + ", correctAnswer=" + correctAnswer + "]";
    }
}
