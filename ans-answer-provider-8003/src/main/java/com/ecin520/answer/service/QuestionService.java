package com.ecin520.answer.service;

import com.ecin520.api.entity.Question;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/2 9:57
 */
public interface QuestionService {
    /**
     * 插入题目
     * @param question 题目对象
     * @return Booelan
     * */
    Boolean insertQuestion(Question question);

    /**
     * 更新题目
     * @param question 题目对象
     * @return Booelan
     * */
    Boolean updateQuestion(Question question);

    /**
     * 删除题目
     * @param id 题目id
     * @return Booelan
     * */
    Boolean deleteQuestion(Integer id);

    /**
     * 列出所有题目
     * @param questionStatus 题目状态
     * @return List<Question>
     * */
    List<Question> listAllQuestions(Integer questionStatus);

    /**
     * 列出某一类型的题目
     * @param typeName 题目类型
     * @param questionStatus 题目状态
     * @return List<Question>
     * */
    List<Question> getQuestionsByTypeName(String typeName, Integer questionStatus);

    /**
     * 获得题目
     * @param id 题目id
     * @return Question
     * */
    Question getQuestionById(Integer id);

    /**
     * 通过用户id获取所出题目
     * @param owner user id
     * @return List<Question>
     * */
    List<Question> listQuestionByOwnerId(Integer owner);
}
