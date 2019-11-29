package com.ecin520.api.service;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author NICE
 */
@Component
@FeignClient(value = "BASIC-PROVIDER", fallbackFactory = UserServiceFallBack.class)
@RequestMapping("/user")
public interface UserService {

	@RequestMapping("/insertUser")
	JSONObject insertUser(User user);

	@RequestMapping("/listAllUsers")
	public List<User> listAllUsers();

	@RequestMapping("/getUserByUsername")
	public User getUserByUsername(String username);

}
