package com.ecin520.basic.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.common.JsonObject;
import com.ecin520.api.common.RandomAvatar;
import com.ecin520.api.common.RandomName;
import com.ecin520.api.entity.User;
import com.ecin520.basic.service.UserService;
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
	public JSONObject insertUser(@RequestParam String username, @RequestParam String password) {

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setNickname(RandomName.getRandomName().toString());
		user.setAvatarUrl(RandomAvatar.getRandomAvatar());

		try {
			userService.insertUser(user);
			return JsonObject.backStatus(200, "注册成功！");
		} catch (Exception e) {
			return JsonObject.backStatus(500, "注册失败，用户名已存在！");
		}

	}

	@RequestMapping("/listAllUsers")
	public List<User> listAllUsers() {
		return userService.listAllUsers();
	}

}
