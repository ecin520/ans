package com.ecin520.basic.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.common.JsonObject;
import com.ecin520.api.entity.Role;
import com.ecin520.basic.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: ecin520
 * @Date: 2019/11/30 10:04
 */
@RestController
@RequestMapping("/userRole")
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;

	@RequestMapping("/insertUserRole")
	public JSONObject insertUserRole(@RequestParam("uid") Integer uid, @RequestParam("rid") Integer rid) {
		if (userRoleService.insertUserRole(uid, rid)) {
			return JsonObject.backStatus(200, "授予用户角色成功！");
		} else {
			return JsonObject.backStatus(500, "授予用户角色失败！");
		}
	}

	@RequestMapping("/deleteUserRole")
	public JSONObject deleteUserRole(@RequestParam("id") Integer id) {
		if (userRoleService.deleteUserRoleById(id)) {
			return JsonObject.backStatus(200, "删除用户角色成功！");
		} else {
			return JsonObject.backStatus(500, "删除用户角色失败！");
		}
	}

	@RequestMapping("/listRolesByUserId")
	public List<Role> listRolesByUserId(@RequestParam("id") Integer id) {
		return userRoleService.listRolesByUserId(id);
	}
}
