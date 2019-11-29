package com.ecin520.api.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: ecin520
 * @Date: 2019/11/29 19:29
 */
@Data
public class UserRole {
	private Integer id;
	private User user;
	private List<Role> roleList;
}
