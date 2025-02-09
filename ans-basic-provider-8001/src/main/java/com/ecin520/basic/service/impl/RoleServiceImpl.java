package com.ecin520.basic.service.impl;

import com.ecin520.api.entity.Role;
import com.ecin520.basic.dao.RoleDao;
import com.ecin520.basic.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ecin520
 * @Date: 2019/11/29 23:23
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Override
	public Boolean insertRole(Role role) {
		return roleDao.insertRole(role);
	}

	@Override
	@CachePut(value = "role", key = "#role.id")
	public Role updateRole(Role role) {
		return roleDao.updateRole(role) ? role : null;
	}

	@Override
	@Cacheable(value = "role", key = "#id")
	public Role getRoleById(Integer id) {
		return roleDao.getRoleById(id);
	}

	@Override
	@CacheEvict(value = "role", key = "#id")
	public Boolean deleteRoleById(Integer id) {
		return roleDao.deleteRoleById(id);
	}

	@Override
	public List<Role> listAllRoles() {
		return roleDao.listAllRoles();
	}
}
