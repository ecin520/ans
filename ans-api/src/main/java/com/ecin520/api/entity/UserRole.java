package com.ecin520.api.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: ecin520
 * @Date: 2019/11/29 19:29
 */
@Data
@Accessors(chain = true)
public class UserRole implements Serializable {
	private Integer id;
	private User user;
	private List<Role> roleList;
}
