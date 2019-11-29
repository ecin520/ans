package com.ecin520.api.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author ecin520
 */
@Data
public class Permission implements Serializable {
	private Integer id;
	private String permission_name;
	private String permission_describe;
}
