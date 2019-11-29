package com.ecin520.basic.service;

import com.ecin520.api.entity.Role;

import java.util.List;

/**
 * @Author: ecin520
 * @Date: 2019/11/29 23:21
 */
public interface UserRoleService {

	Boolean insertUserRole(Integer uid, Integer rid);

	Boolean updateUserRole(Integer uid, Integer rid);

	Boolean deleteUserRoleById(Integer id);

	List<Role> listRolesByUserId(Integer id);
}
