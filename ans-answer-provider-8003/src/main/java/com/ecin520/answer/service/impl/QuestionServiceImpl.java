package com.ecin520.answer.service.impl;

import com.ecin520.answer.service.QuestionService;
import com.ecin520.api.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/2 9:58
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionService questionService;

    public QuestionServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Boolean insertQuestion(Question question) {
        return questionService.insertQuestion(question);
    }

    public Boolean updateQuestion(Question question) {
        return updateQuestion(question);
    }

    public Boolean deleteQuestion(Integer id) {
        return deleteQuestion(id);
    }

    public List<Question> listAllQuestions() {
        return listAllQuestions();
    }

    public List<Question> getQuestionByTypeName(String typeName) {
        return getQuestionByTypeName(typeName);
    }

    public Question getQuestionById(Integer id) {
        return getQuestionById(id);
    }
}
