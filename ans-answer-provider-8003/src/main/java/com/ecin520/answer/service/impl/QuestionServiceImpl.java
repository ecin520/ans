package com.ecin520.answer.service.impl;

import com.ecin520.answer.dao.QuestionDao;
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

    @Autowired
    private QuestionDao questionDao;

    @Override
    public Boolean insertQuestion(Question question) {
        return questionDao.insertQuestion(question);
    }

    @Override
    public Boolean updateQuestion(Question question) {
        return questionDao.updateQuestion(question);
    }

    @Override
    public Boolean deleteQuestion(Integer id) {
        return questionDao.deleteQuestion(id);
    }

    @Override
    public List<Question> listAllQuestions(Integer questionStatus) {
        return questionDao.listAllQuestions(questionStatus);
    }

    @Override
    public List<Question> getQuestionsByTypeName(String typeName, Integer questionStatus) {
        return questionDao.getQuestionsByTypeName(typeName, questionStatus);
    }

    @Override
    public Question getQuestionById(Integer id) {
        return questionDao.getQuestionById(id);
    }
}
