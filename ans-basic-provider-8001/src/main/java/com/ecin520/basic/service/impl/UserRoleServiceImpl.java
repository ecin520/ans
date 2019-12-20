package com.ecin520.basic.service.impl;

import com.ecin520.api.entity.Role;
import com.ecin520.api.entity.UserRole;
import com.ecin520.basic.dao.UserRoleDao;
import com.ecin520.basic.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ecin520
 * @Date: 2019/11/29 23:24
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleDao userRoleDao;

	@Override
	public Boolean insertUserRole(Integer uid, Integer rid) {
		return userRoleDao.insertUserRole(uid, rid);
	}

	@Override
	public Boolean updateUserRole(UserRole userRole) {
		return userRoleDao.updateUserRole(userRole);
	}

	@Override
	public Boolean deleteUserRoleById(Integer uid, Integer rid) {
		return userRoleDao.deleteUserRoleById(uid, rid);
	}

	@Override
	public List<Role> listRolesByUserId(Integer id) {
		return userRoleDao.listRolesByUserId(id);
	}
}
