package com.ecin520.basic.dao;

import com.ecin520.api.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author NICE
 * @Date: 2019/11/28 10:41
 */
@Mapper
public interface PermissionDao {

	Boolean insertPermission(Permission permission);

	Boolean updatePermission(Permission permission);

	Permission getPermissionById(Integer id);

	Boolean deletePermissionById(Integer id);

	List<Permission> listAllPermissions();

}
