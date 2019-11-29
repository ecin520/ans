package com.ecin520.basic.service;

import com.ecin520.api.entity.Permission;

/**
 * @Author: ecin520
 * @Date: 2019/11/29 23:21
 */
public interface PermissionService {

	Boolean insertPermission(Permission permission);

	Boolean updatePermission(Permission permission);

	Permission getPermissionById(Integer id);

	Boolean deletePermissionById(Integer id);
}
