package com.ecin520.basic.dao;

import com.ecin520.api.entity.Role;
import com.ecin520.api.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: ecin520
 * @Date: 2019/11/29 19:43
 */
@Mapper
public interface UserRoleDao {

	Boolean insertUserRole(Integer uid, Integer rid);

	Boolean updateUserRole(Integer uid, Integer rid);

	Boolean deleteUserRoleById(Integer uid, Integer rid);

	List<Role> listRolesByUserId(Integer id);

}
