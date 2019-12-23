package com.ecin520.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.Question;
import com.ecin520.api.service.answer.QuestionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	@RequiresPermissions("devote question")
	@CrossOrigin
	public JSONObject insertQuestion(@RequestBody Question question) {
		return questionService.insertQuestion(question);
	}

	@RequestMapping("/updateQuestion")
	@RequiresPermissions({"devote question", "review question"})
	@CrossOrigin
	public JSONObject updateQuestion(@RequestBody Question question) {
		return questionService.updateQuestion(question);
	}

	@RequestMapping("/deleteQuestion")
	@RequiresPermissions({"devote question", "review question"})
	@CrossOrigin
	public JSONObject deleteQuestion(@RequestParam("id") Integer id) {
		return questionService.deleteQuestion(id);
	}

	@RequestMapping("/getQuestionsByTypeName")
	@RequiresRoles("normal user")
	@CrossOrigin
	public List<Question> getQuestionsByTypeName(@RequestParam("typeName") String typeName, @RequestParam("questionStatus") Integer questionStatus) {
		return questionService.getQuestionsByTypeName(typeName, questionStatus);
	}

	@RequestMapping("/listAllQuestions")
	@RequiresRoles("normal user")
	@CrossOrigin
	public List<Question> listAllQuestions(@RequestParam("status") Integer status) {
		return questionService.listAllQuestions(status);
	}

	@RequestMapping("/getQuestionById")
	@RequiresRoles("normal user")
	@CrossOrigin
	public Question getQuestionById(@RequestParam("id") Integer id) {
		return questionService.getQuestionById(id);
	}

	@RequestMapping("/listQuestionByOwnerId")
	@RequiresRoles("normal user")
	@CrossOrigin
	public List<Question> listQuestionByOwnerId(@RequestParam("owner") Integer owner) {
		return questionService.listQuestionByOwnerId(owner);
	}

}
