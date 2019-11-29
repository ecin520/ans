package com.ecin520.basic.service;

import com.ecin520.api.entity.Role;

/**
 * @Author: ecin520
 * @Date: 2019/11/29 23:21
 */
public interface RoleService {

	Boolean insertRole(Role role);

	Boolean updateRole(Role role);

	Role getRoleById(Integer id);

	Boolean deleteRoleById(Integer id);
}
