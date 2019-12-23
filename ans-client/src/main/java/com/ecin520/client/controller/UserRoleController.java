package com.ecin520.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.Role;
import com.ecin520.api.service.basic.UserRoleService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: ecin520
 * @date: 2019/12/3 21:42
 */
@RestController
@RequestMapping("/client/userRole")
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;

	@RequestMapping("/insertUserRole")
	@RequiresRoles("admin")
	@CrossOrigin
	public JSONObject insertUserRole(@RequestParam("uid") Integer uid, @RequestParam("rid") Integer rid) {
		return userRoleService.insertUserRole(uid, rid);
	}

	@RequestMapping("/deleteUserRole")
	@RequiresRoles("admin")
	@CrossOrigin
	public JSONObject deleteUserRole(@RequestParam("uid") Integer uid, @RequestParam("rid") Integer rid) {
		return userRoleService.deleteUserRole(uid, rid);
	}

	@RequestMapping("/listRolesByUserId")
	@RequiresRoles("normal user")
	@CrossOrigin
	public List<Role> listRolesByUserId(@RequestParam("id") Integer id) {
		return userRoleService.listRolesByUserId(id);
	}


}
