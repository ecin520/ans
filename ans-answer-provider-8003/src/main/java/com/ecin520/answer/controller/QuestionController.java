package com.ecin520.answer.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.answer.service.QuestionService;
import com.ecin520.api.common.JsonObject;
import com.ecin520.api.entity.Question;
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
@RequestMapping("/question")
public class QuestionController {

	private QuestionService questionService;

	@Autowired
	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}

	@RequestMapping("/insertQuestion")
	public JSONObject insertQuestion(@RequestBody Question question) {
		if (questionService.insertQuestion(question)) {
			return JsonObject.backStatus(200, "插入题目成功！");
		} else {
			return JsonObject.backStatus(500, "插入题目失败！");
		}
	}

	@RequestMapping("/updateQuestion")
	public JSONObject updateQuestion(@RequestBody Question question) {
		if (questionService.updateQuestion(question)) {
			return JsonObject.backStatus(200, "更新题目成功！");
		} else {
			return JsonObject.backStatus(500, "更新题目失败！");
		}
	}

	@RequestMapping("/deleteQuestion")
	public JSONObject deleteQuestion(@RequestParam("id") Integer id) {
		if (questionService.deleteQuestion(id)) {
			return JsonObject.backStatus(200, "删除题目成功！");
		} else {
			return JsonObject.backStatus(500, "删除题目失败！");
		}
	}

	@RequestMapping("/getQuestionsByTypeName")
	List<Question> getQuestionsByTypeName(@RequestParam("typeName") String typeName) {
		return questionService.getQuestionsByTypeName(typeName);
	}

	@RequestMapping("/getQuestionById")
	Question getQuestionById(@RequestParam("id") Integer id) {
		return questionService.getQuestionById(id);
	}


}
