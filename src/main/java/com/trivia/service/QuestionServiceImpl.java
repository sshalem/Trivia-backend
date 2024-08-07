package com.trivia.service;

import java.util.List;

import com.trivia.model.QuestionDto;
import com.trivia.utils.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trivia.entity.QuestionEntity;
import com.trivia.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    private QuestionEntity questionById;

    @Override
    public List<QuestionEntity> getAllQuestions() {
        List<QuestionEntity> entities = questionRepository.findAll();
//        entities.forEach(System.out::println);
        return questionRepository.findAll();
    }

    @Override
    public QuestionEntity addQuestion(QuestionDto questionDto) {
        System.out.println(questionDto);
        QuestionEntity questionEntity = convertQuestionDtoToQuestionEntity(questionDto);
        return questionRepository.save(questionEntity);
    }

    @Override
    public QuestionEntity updateQuestion(QuestionDto questionDto) {
        System.out.println(questionDto);
        return null;
    }

    @Override
    public QuestionDto getQuestionById(long id) {
        return convertQuestionEntityToQuestionDto(questionRepository.findQuestionById(id));
    }

    /**
     * Helper methods
     */
    private QuestionDto convertQuestionEntityToQuestionDto(QuestionEntity questionEntity) {
        /**
         * Convert the answers String to a String Array of 4 elements.
         * I Split the Answer String by regex of "[|]"
         */
        String answers = questionEntity.getAnswers();
        String[] answersSplitAndTrim = new String[4];
        String regex = "[|]";
        String[] answersSplited = answers.split(regex);

        for (int i = 0; i < answersSplitAndTrim.length; i++) {
            // Trim the string (Removes space at start/end of string
            answersSplitAndTrim[i] = answersSplited[i].trim();
        }

        // Arrays.stream(answersSplitAndTrim).forEach(System.out::println);

        /**
         * Copy Objects properties to QuestionDto
         */
        QuestionDto returnedValue = new QuestionDto();
        BeanUtils.copyProperties(questionEntity, returnedValue);
        returnedValue.setAnswers(answersSplitAndTrim);
        return returnedValue;
    }

    private QuestionEntity convertQuestionDtoToQuestionEntity(QuestionDto questionDto) {

        String[] answersStringArray = questionDto.getAnswers();

        String regex = " | ";

        String answers =
                answersStringArray[0] + regex +
                        answersStringArray[1] + regex +
                        answersStringArray[2] + regex +
                        answersStringArray[3];

        Log.yellow(answers);

        /**
         * Copy Objects properties to QuestionDto
         */
        QuestionEntity returnedValue = new QuestionEntity();
        BeanUtils.copyProperties(questionDto, returnedValue);
        returnedValue.setAnswers(answers);
        return returnedValue;
    }
}
