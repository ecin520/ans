package com.ecin520.basic.service.impl;

import com.ecin520.api.entity.Permission;
import com.ecin520.basic.dao.PermissionDao;
import com.ecin520.basic.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ecin520
 * @Date: 2019/11/29 23:24
 */
@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionDao permissionDao;

	public Boolean insertPermission(Permission permission) {
		return permissionDao.insertPermission(permission);
	}

	public Boolean updatePermission(Permission permission) {
		return permissionDao.updatePermission(permission);
	}

	public Permission getPermissionById(Integer id) {
		return permissionDao.getPermissionById(id);
	}

	public Boolean deletePermissionById(Integer id) {
		return permissionDao.deletePermissionById(id);
	}

	public List<Permission> listAllPermissions() {
		return permissionDao.listAllPermissions();
	}
}
