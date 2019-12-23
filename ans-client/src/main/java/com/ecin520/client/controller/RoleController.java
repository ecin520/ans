package com.ecin520.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.Role;
import com.ecin520.api.service.basic.RoleService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: ecin520
 * @date: 2019/12/3 21:28
 */
@RestController
@RequestMapping("/client/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@RequestMapping("/insertRole")
	@RequiresRoles("admin")
	public JSONObject insertRole(@RequestParam("role_name") String roleName, @RequestParam("role_describe") String roleDescribe) {
		return roleService.insertRole(roleName, roleDescribe);
	}

	@RequestMapping("/listAllRoles")
	@RequiresRoles("normal user")
	@CrossOrigin
	public List<Role> listAllRoles() {
		return roleService.listAllRoles();
	}

	@RequestMapping("/updateRole")
	@RequiresRoles("admin")
	public JSONObject updateRole(@RequestBody Role role) {
		return roleService.updateRole(role);
	}

	@RequestMapping("/getRoleById")
	@RequiresRoles("normal user")
	@CrossOrigin
	public Role getRoleById(@RequestParam("id") Integer id) {
		return roleService.getRoleById(id);
	}

	@RequestMapping("/deleteRoleById")
	@RequiresRoles("admin")
	public JSONObject deleteRoleById(@RequestParam("id") Integer id) {
		return roleService.deleteRoleById(id);
	}

}
