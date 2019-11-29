package com.ecin520.basic.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.common.JsonObject;
import com.ecin520.api.entity.Role;
import com.ecin520.basic.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ecin520
 * @Date: 2019/11/29 23:33
 */
@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@RequestMapping("/insertRole")
	public JSONObject insertRole(@RequestParam("roleName") String roleName, @RequestParam("roleDescribe") String roleDescribe) {
		Role role = new Role();
		role.setRole_name(roleName);
		role.setRole_describe(roleDescribe);
		if (roleService.insertRole(role)) {
			return JsonObject.backStatus(200, "添加角色信息成功！");
		} else {
			return JsonObject.backStatus(500, "添加角色信息失败！");
		}
	}

}
