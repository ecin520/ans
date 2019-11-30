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

/**
 * @Author NICE
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/insertUser")
//	@HystrixCommand(fallbackMethod = "insertUserFallBack")
	public JSONObject insertUser(@RequestBody User user) {

		if (user.getNickname() == null) {
			user.setNickname(RandomName.getRandomName().toString());
		}
		if (user.getAvatar_url() == null) {
			user.setAvatar_url(RandomAvatar.getRandomAvatar());
		}

		try {
			userService.insertUser(user);
			return JsonObject.backStatus(200, "注册成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return JsonObject.backStatus(500, user.getUsername() + "注册失败！");
		}

	}

	@RequestMapping("/updateUser")
	public JSONObject updateUser(@RequestBody User user) {
		if (userService.updateUser(user)) {
			return JsonObject.backStatus(200, "修改成功！");
		} else {
			return JsonObject.backStatus(500, user.getUsername() + "修改失败！");
		}
	}

	@RequestMapping("/deleteUserById")
	public JSONObject deleteUserById(@RequestParam("id") Integer id) {
		if (userService.deleteUserById(id)) {
			return JsonObject.backStatus(200, "删除成功！");
		} else {
			return JsonObject.backStatus(500, "删除失败！");
		}
	}

	/**
	 * 注册失败的回调方法
	 * */
	public JSONObject insertUserFallBack(@RequestParam("username") String username, @RequestParam("password") String password) {
		return JsonObject.backStatus(500, username + "注册失败-熔断回调");
	}

	/**
	 * 获取所有用户
	 * */
	@RequestMapping("/listAllUsers")
	public List<User> listAllUsers() {

		return userService.listAllUsers();

	}

	/**
	 * 通过用户名获取用户信息
	 * */
	@RequestMapping("/getUserByUsername")
	public User getUserByUsername(@RequestParam("username") String username) {
		return userService.getUserByUsername(username);
	}


}
