package com.ecin520.basic.dao;

import com.ecin520.api.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: ecin520
 * @Date: 2019/11/29 19:43
 */
@Mapper
public interface RolePermissionDao {

	Boolean insertRolePermission(Integer rid, Integer pid);

	Boolean updateRolePermission(Integer rid, Integer pid);

	Boolean deleteRolePermissionById(Integer id);

	List<Permission> listPermissionsByUserId(Integer id);

	List<Permission> listPermissionsByRoleId(Integer rid);

}
