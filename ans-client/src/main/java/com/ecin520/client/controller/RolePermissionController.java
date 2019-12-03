package com.ecin520.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.Permission;
import com.ecin520.api.service.basic.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: ecin520
 * @date: 2019/12/3 21:45
 */
@RestController
@RequestMapping("/client/rolePermission")
public class RolePermissionController {

	@Autowired
	private RolePermissionService rolePermissionService;

	@RequestMapping("/insertRolePermission")
	public JSONObject insertRolePermission(@RequestParam("rid") Integer rid, @RequestParam("pid") Integer pid) {
		return rolePermissionService.insertRolePermission(rid, pid);
	}

	/**
	 * 删除角色权限
	 * @param id 角色权限id
	 * */
	@RequestMapping("/deleteRolePermission")
	public JSONObject deleteRolePermission(@RequestParam("id") Integer id) {
		return rolePermissionService.deleteRolePermission(id);
	}

	/**
	 * 通过用户id获取其所有权限
	 * @param id 用户ud
	 * */
	@RequestMapping("/listPermissionsByUserId")
	public List<Permission> listRolesByUserId(@RequestParam("id") Integer id) {
		return rolePermissionService.listPermissionsByUserId(id);
	}

	/**
	 * 通过角色id获取该角色所有权限
	 * @param rid 角色id
	 * */
	@RequestMapping("/listPermissionsByRoleId")
	public List<Permission> listPermissionsByRoleId(@RequestParam("rid") Integer rid) {
		return rolePermissionService.listPermissionsByRoleId(rid);
	}


}
