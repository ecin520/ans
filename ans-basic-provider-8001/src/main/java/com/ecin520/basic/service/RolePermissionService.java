package com.ecin520.basic.service;

import com.ecin520.api.entity.Permission;

import java.util.List;

/**
 * @Author: ecin520
 * @Date: 2019/11/29 23:22
 */
public interface RolePermissionService {

	Boolean insertRolePermission(Integer rid, Integer pid);

	Boolean updateRolePermission(Integer rid, Integer pid);

	Boolean deleteRolePermissionById(Integer id);

	List<Permission> listPermissionsByUserId(Integer id);
}
