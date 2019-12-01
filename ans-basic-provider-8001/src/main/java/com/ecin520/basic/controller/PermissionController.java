package com.ecin520.basic.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.common.JsonObject;
import com.ecin520.api.entity.Permission;
import com.ecin520.basic.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: ecin520
 * @Date: 2019/11/30 9:54
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;


	/**
	 * 插入权限
	 * url: /permission/insertPermission
	 * @param permission 权限信息，包含permission_name,permission_describe
	 * @return JSONObject
	 * */
	@RequestMapping("/insertPermission")
	public JSONObject insertPermission(@RequestBody Permission permission) {
		if (permissionService.insertPermission(permission)) {
			return JsonObject.backStatus(200,"添加权限成功！");
		} else {
			return JsonObject.backStatus(500,"添加权限失败！");
		}
	}

	/**
	 * 获取所有权限
	 * @return List<Permission>
	 * */
	@RequestMapping("/listAllPermissions")
	public List<Permission> listAllPermissions() {
		return permissionService.listAllPermissions();
	}

	/**
	 * 更新权限信息
	 * @param permission 权限信息
	 * @return JSONObject
	 * */
	@RequestMapping("/updatePermission")
	public JSONObject updatePermission(@RequestBody Permission permission) {
		if (permissionService.updatePermission(permission)) {
			return JsonObject.backStatus(200, "修改权限成功");
		} else {
			return JsonObject.backStatus(500, "修改权限失败！");
		}
	}

	/**
	 * 通过权限id获取权限信息
	 * @param id 权限id
	 * @return Permission
	 * */
	@RequestMapping("/getPermissionById")
	public Permission getPermissionById(@RequestParam("id")Integer id) {
		return permissionService.getPermissionById(id);
	}

	/**
	 * 通过权限id删除权限
	 * @param id 权限id
	 * @return JSONObject
	 * */
	@RequestMapping("/deletePermissionById")
	public JSONObject deletePermissionById(@RequestParam("id")Integer id) {
		if (permissionService.deletePermissionById(id)) {
			return JsonObject.backStatus(200, "删除权限成功！");
		} else {
			return JsonObject.backStatus(500, "删除权限败！");
		}
	}




}
