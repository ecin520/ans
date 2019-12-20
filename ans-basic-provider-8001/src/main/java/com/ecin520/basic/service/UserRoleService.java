package com.ecin520.basic.service;

import com.ecin520.api.entity.Role;
import com.ecin520.api.entity.UserRole;

import java.util.List;

/**
 * @Author: ecin520
 * @Date: 2019/11/29 23:21
 */
public interface UserRoleService {

	Boolean insertUserRole(Integer uid, Integer rid);

	Boolean updateUserRole(UserRole userRole);

	Boolean deleteUserRoleById(Integer uid, Integer rid);

	List<Role> listRolesByUserId(Integer id);
}
