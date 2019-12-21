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

	/**
	 * 插入用户
	 * */
	@RequestMapping("/insertUser")
	public JSONObject insertUser(@RequestBody User user) {

		// 昵称为空则随机取名
		if (user.getNickname() == null) {
			user.setNickname(RandomName.getRandomName().toString());
		}
		// 头像随机赋予
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
	/**
	 * 注册失败的回调方法
	 * */
	public JSONObject insertUserFallBack(@RequestParam("username") String username, @RequestParam("password") String password) {
		return JsonObject.backStatus(500, username + "注册失败-熔断回调");
	}

	/**
	* 用户数据更新
	* */
	@RequestMapping("/updateUser")
	public JSONObject updateUser(@RequestBody User user) {
		if (null != userService.updateUser(user)) {
			return JsonObject.backStatus(200, "修改成功！");
		} else {
			return JsonObject.backStatus(500, user.getUsername() + "修改失败！");
		}
	}

	/**
	 * 通过用户id删除用户
	 * */
	@RequestMapping("/deleteUserById")
	public JSONObject deleteUserById(@RequestParam("id") Integer id) {
		if (userService.deleteUserById(id)) {
			return JsonObject.backStatus(200, "删除成功！");
		} else {
			return JsonObject.backStatus(500, "删除失败！");
		}
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

	/**
	 * 通过用户id获取用户信息
	 * */
	@RequestMapping("/getUserById")
	public User getUserById(@RequestParam("id") Integer id) {
		return userService.getUserById(id);
	}

	@RequestMapping("/addExperience")
	public JSONObject addExperience(@RequestParam("userId") Integer userId, @RequestParam("exp") Integer exp) {
		User user = userService.getUserById(userId);

		if (exp >  10) {
			return JsonObject.backStatus(500, "请勿破坏游戏规则！违者封号！");
		}
		if (userService.addExperience(userId, user.getRank() + exp)) {
			return JsonObject.backStatus(200, "添加经验成功！");
		} else {
			return JsonObject.backStatus(500, "添加经验失败！");
		}
	}

}
