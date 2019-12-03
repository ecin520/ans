package com.ecin520.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.Question;
import com.ecin520.api.service.answer.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/2 10:03
 */
@RestController
@RequestMapping("/client/question")
public class QuestionController {

	private QuestionService questionService;

	@Autowired
	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}

	@RequestMapping("/insertQuestion")
	public JSONObject insertQuestion(@RequestBody Question question) {
		return questionService.insertQuestion(question);
	}

	@RequestMapping("/updateQuestion")
	public JSONObject updateQuestion(@RequestBody Question question) {
		return questionService.updateQuestion(question);
	}

	@RequestMapping("/deleteQuestion")
	public JSONObject deleteQuestion(@RequestParam("id") Integer id) {
		return questionService.deleteQuestion(id);
	}

	@RequestMapping("/getQuestionsByTypeName")
	public List<Question> getQuestionsByTypeName(@RequestParam("typeName") String typeName) {
		return questionService.getQuestionsByTypeName(typeName);
	}

	@RequestMapping("/getQuestionById")
	public Question getQuestionById(@RequestParam("id") Integer id) {
		return questionService.getQuestionById(id);
	}


}
