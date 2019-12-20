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

	/**
	 * 插入角色
	 * @param roleName 角色名称
	 * @param roleDescribe 角色描述
	 * */
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

	/**
	 * 获取所有角色
	 * @return List<Role>
	 * */
	@RequestMapping("/listAllRoles")
	public List<Role> listAllRoles() {
		return roleService.listAllRoles();
	}

	/**
	 * 修改角色
	 * @param role 传入的角色
	 * */
	@RequestMapping("/updateRole")
	public JSONObject updateRole(@RequestBody Role role) {
		if (null != roleService.updateRole(role)) {
			return JsonObject.backStatus(200, "修改成功");
		} else {
			return JsonObject.backStatus(500, "修改失败！");
		}
	}

	/**
	 * 通过角色id获取角色
	 * @param id 角色id
	 * @return Role
	 * */
	@RequestMapping("/getRoleById")
	public Role getRoleById(@RequestParam("id") Integer id) {
		return roleService.getRoleById(id);
	}

	/**
	 * 通过角色id删除角色
	 * @param id 角色id
	 * @return JSONObject
	 * */
	@RequestMapping("/deleteRoleById")
	public JSONObject deleteRoleById(@RequestParam("id") Integer id) {
		if (roleService.deleteRoleById(id)) {
			return JsonObject.backStatus(200, "删除角色成功！");
		} else {
			return JsonObject.backStatus(500, "删除角色失败！");
		}
	}

}
