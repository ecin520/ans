package com.ecin520.basic.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.common.JsonObject;
import com.ecin520.api.entity.Role;
import com.ecin520.basic.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	public JSONObject insertRole(@RequestParam("role_name") String roleName, @RequestParam("role_describe") String roleDescribe) {
		Role role = new Role();
		role.setRole_name(roleName);
		role.setRole_describe(roleDescribe);
		if (roleService.insertRole(role)) {
			return JsonObject.backStatus(200, "添加角色信息成功！");
		} else {
			return JsonObject.backStatus(500, "添加角色信息失败！");
		}
	}

	@RequestMapping("/listAllRoles")
	public List<Role> listAllRoles() {
		return roleService.listAllRoles();
	}

	@RequestMapping("/updateRole")
	public JSONObject updateRole(@RequestBody Role role) {
		if (roleService.updateRole(role)) {
			return JsonObject.backStatus(200, "修改成功");
		} else {
			return JsonObject.backStatus(500, "修改失败！");
		}
	}

	@RequestMapping("/getRoleById")
	public Role getRoleById(@RequestParam("id") Integer id) {
		return roleService.getRoleById(id);
	}

	@RequestMapping("/deleteRoleById")
	public JSONObject deleteRoleById(@RequestParam("id") Integer id) {
		if (roleService.deleteRoleById(id)) {
			return JsonObject.backStatus(200, "删除角色成功！");
		} else {
			return JsonObject.backStatus(500, "删除角色失败！");
		}
	}

}
