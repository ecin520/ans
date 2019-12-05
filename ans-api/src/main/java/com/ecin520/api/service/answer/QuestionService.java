package com.ecin520.api.service.answer;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/3 9:39
 */
@Component
@FeignClient(value = "ANSWER-PROVIDER")
@RequestMapping("/question")
public interface QuestionService {

    @RequestMapping("/insertQuestion")
    JSONObject insertQuestion(@RequestBody Question question);

    @RequestMapping("/updateQuestion")
    JSONObject updateQuestion(@RequestBody Question question);

    @RequestMapping("/deleteQuestion")
    JSONObject deleteQuestion(@RequestParam("id") Integer id);

    @RequestMapping("/getQuestionsByTypeName")
    List<Question> getQuestionsByTypeName(@RequestParam("typeName") String typeName, @RequestParam("questionStatus") Integer questionStatus);

    @RequestMapping("/listAllQuestions")
    List<Question> listAllQuestions(@RequestParam("status") Integer status);

    @RequestMapping("/getQuestionById")
    Question getQuestionById(@RequestParam("id") Integer id);
}
