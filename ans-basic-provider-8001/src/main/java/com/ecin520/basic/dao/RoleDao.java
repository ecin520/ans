package com.ecin520.basic.dao;

import com.ecin520.api.entity.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author NICE
 * @Date: 2019/11/28 10:41
 */
@Mapper
public interface RoleDao {

	Boolean insertRole(Role role);

	Boolean updateRole(Role role);

	Role getRoleById(Integer id);

	Boolean deleteRoleById(Integer id);

	List<Role> listAllRoles();



}
