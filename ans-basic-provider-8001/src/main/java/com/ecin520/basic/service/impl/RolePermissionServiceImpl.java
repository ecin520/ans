package com.ecin520.basic.service.impl;

import com.ecin520.api.entity.Permission;
import com.ecin520.basic.dao.RolePermissionDao;
import com.ecin520.basic.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ecin520
 * @Date: 2019/11/29 23:25
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

	@Autowired
	private RolePermissionDao rolePermissionDao;

	public Boolean insertRolePermission(Integer rid, Integer pid) {
		return rolePermissionDao.insertRolePermission(rid, pid);
	}

	public Boolean updateRolePermission(Integer rid, Integer pid) {
		return rolePermissionDao.updateRolePermission(rid, pid);
	}

	public Boolean deleteRolePermissionById(Integer id) {
		return rolePermissionDao.deleteRolePermissionById(id);
	}

	public List<Permission> listPermissionsByUserId(Integer id) {
		return rolePermissionDao.listPermissionsByUserId(id);
	}
}
