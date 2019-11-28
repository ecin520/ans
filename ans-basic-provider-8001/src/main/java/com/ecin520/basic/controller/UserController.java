package com.ecin520.basic.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.common.JsonObject;
import com.ecin520.api.common.RandomAvatar;
import com.ecin520.api.common.RandomName;
import com.ecin520.api.entity.User;
import com.ecin520.basic.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/insertUser")
	@HystrixCommand(fallbackMethod = "insertUserFallBack")
	public JSONObject insertUser(@RequestParam String username, @RequestParam String password) {

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setNickname(RandomName.getRandomName().toString());
		user.setAvatar_url(RandomAvatar.getRandomAvatar());

		return JsonObject.backStatus(200, "注册成功！");

	}

	/**
	 * 注册失败的回调方法
	 * */
	public JSONObject insertUserFallBack(@RequestParam String username, @RequestParam String password) {
		return JsonObject.backStatus(500, username + "注册失败！");
	}

	@RequestMapping("/listAllUsers")
	public List<User> listAllUsers() {

		return userService.listAllUsers();

	}

	@RequestMapping("/getUserByUsername")
	public User getUserByUsername(@RequestParam String username) {
		return userService.getUserByUsername(username);
	}

}
