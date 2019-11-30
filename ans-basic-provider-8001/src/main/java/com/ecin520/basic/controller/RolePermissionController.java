package com.ecin520.basic.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.common.JsonObject;
import com.ecin520.api.entity.Permission;
import com.ecin520.api.entity.RolePermission;
import com.ecin520.basic.service.RolePermissionService;
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
@RequestMapping("/rolePermission")
public class RolePermissionController {

	@Autowired
	private RolePermissionService rolePermissionService;

	@RequestMapping("/insertRolePermission")
	public JSONObject insertRolePermission(@RequestParam("rid") Integer rid, @RequestParam("pid") Integer pid) {
		if (rolePermissionService.insertRolePermission(rid, pid)) {
			return JsonObject.backStatus(200, "授予角色权限成功！");
		} else {
			return JsonObject.backStatus(500, "授予角色权限失败！");
		}
	}

	@RequestMapping("/deleteRolePermission")
	public JSONObject deleteRolePermission(@RequestParam("id") Integer id) {
		if (rolePermissionService.deleteRolePermissionById(id)) {
			return JsonObject.backStatus(200, "删除用户角色成功！");
		} else {
			return JsonObject.backStatus(500, "删除用户角色失败！");
		}
	}

	@RequestMapping("/listPermissionsByUserId")
	public List<Permission> listRolesByUserId(@RequestParam("id") Integer id) {
		return rolePermissionService.listPermissionsByUserId(id);
	}
}
