package com.ecin520.answer.dao;

import com.ecin520.api.entity.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/2 9:54
 */
@Mapper
public interface QuestionDao {

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
     * @return List<Question>
     * */
    List<Question> listAllQuestions();

    /**
     * 列出某一类型的题目
     * @param typeName 题目类型
     * @return List<Question>
     * */
    List<Question> getQuestionByTypeName(String typeName);

    /**
     * 获得题目
     * @param id 题目id
     * @return Question
     * */
    Question getQuestionById(Integer id);

}
