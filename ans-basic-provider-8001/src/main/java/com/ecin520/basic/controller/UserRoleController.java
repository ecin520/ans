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

	/**
	 * 授予用户角色
	 * @param uid 用户的id
	 * @param rid 角色id
	 * */
	@RequestMapping("/insertUserRole")
	public JSONObject insertUserRole(@RequestParam("uid") Integer uid, @RequestParam("rid") Integer rid) {
		if (userRoleService.insertUserRole(uid, rid)) {
			return JsonObject.backStatus(200, "授予用户角色成功！");
		} else {
			return JsonObject.backStatus(500, "授予用户角色失败！");
		}
	}

	/**
	 * 删除角色
	 * @param uid 用户的id
	 * @param rid 角色id
	* */
	@RequestMapping("/deleteUserRole")
	public JSONObject deleteUserRole(@RequestParam("uid") Integer uid, @RequestParam("rid") Integer rid) {
		if (userRoleService.deleteUserRoleById(uid, rid)) {
			return JsonObject.backStatus(200, "删除用户角色成功！");
		} else {
			return JsonObject.backStatus(500, "删除用户角色失败！");
		}
	}

	/**
	* 通过用户id获取其所有角色信息
	 * @param id 用户id
	* */
	@RequestMapping("/listRolesByUserId")
	public List<Role> listRolesByUserId(@RequestParam("id") Integer id) {
		return userRoleService.listRolesByUserId(id);
	}
}
