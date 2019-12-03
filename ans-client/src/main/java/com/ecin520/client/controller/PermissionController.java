package com.ecin520.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.Permission;
import com.ecin520.api.service.basic.PermissionService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: ecin520
 * @date: 2019/12/3 21:39
 */
@RestController
@RequestMapping("/client/permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

	@RequestMapping("/insertPermission")
	@RequiresRoles("admin")
	public JSONObject insertPermission(@RequestBody Permission permission) {
		return permissionService.insertPermission(permission);
	}

	@RequestMapping("/listAllPermissions")
	public List<Permission> listAllPermissions() {
		return permissionService.listAllPermissions();
	}

	@RequestMapping("/updatePermission")
	public JSONObject updatePermission(@RequestBody Permission permission) {
		return permissionService.updatePermission(permission);
	}

	@RequestMapping("/getPermissionById")
	public Permission getPermissionById(@RequestParam("id")Integer id) {
		return permissionService.getPermissionById(id);
	}

	@RequestMapping("/deletePermissionById")
	JSONObject deletePermissionById(@RequestParam("id")Integer id) {
		return permissionService.deletePermissionById(id);
	}

}
