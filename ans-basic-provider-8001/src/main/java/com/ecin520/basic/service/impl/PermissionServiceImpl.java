package com.ecin520.basic.service.impl;

import com.ecin520.api.entity.Permission;
import com.ecin520.basic.dao.PermissionDao;
import com.ecin520.basic.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

	@Override
	public Boolean insertPermission(Permission permission) {
		return permissionDao.insertPermission(permission);
	}

	@Override
	@CachePut(value = {"permission"}, key = "#permission.id")
	public Permission updatePermission(Permission permission) {
		return permissionDao.updatePermission(permission) ? permission : null;
	}

	@Override
	@Cacheable(value = {"permission"}, key = "#id")
	public Permission getPermissionById(Integer id) {
		return permissionDao.getPermissionById(id);
	}

	@Override
	@CacheEvict(value = {"permission"}, key = "#id")
	public Boolean deletePermissionById(Integer id) {
		return permissionDao.deletePermissionById(id);
	}

	@Override
	public List<Permission> listAllPermissions() {
		return permissionDao.listAllPermissions();
	}
}
