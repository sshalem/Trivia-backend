package com.trivia.service;

import com.trivia.entity.QuestionEntity;
import com.trivia.model.QuestionDto;

import java.util.List;

public interface QuestionService {

    List<QuestionEntity> getAllQuestions();

    QuestionDto getQuestionById(long id);

    QuestionEntity addQuestion(QuestionDto questionDto);

    QuestionEntity updateQuestion(QuestionDto questionDto);
}
