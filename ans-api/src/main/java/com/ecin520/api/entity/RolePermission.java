package com.ecin520.api.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author: ecin520
 * @Date: 2019/11/29 19:28
 */
@Data
@Accessors(chain = true)
public class RolePermission {
	private Integer id;
	private Role role;
	private List<Permission> permissionList;
}
