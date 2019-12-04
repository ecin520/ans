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

    private QuestionDao questionDao;

    @Autowired
    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }


    public Boolean insertQuestion(Question question) {
        return questionDao.insertQuestion(question);
    }

    public Boolean updateQuestion(Question question) {
        return questionDao.updateQuestion(question);
    }

    public Boolean deleteQuestion(Integer id) {
        return questionDao.deleteQuestion(id);
    }

    public List<Question> listAllQuestions(Integer questionStatus) {
        return questionDao.listAllQuestions(questionStatus);
    }

    public List<Question> getQuestionsByTypeName(String typeName, Integer questionStatus) {
        return questionDao.getQuestionsByTypeName(typeName, questionStatus);
    }

    public Question getQuestionById(Integer id) {
        return questionDao.getQuestionById(id);
    }
}
