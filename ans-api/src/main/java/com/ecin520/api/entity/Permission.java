package com.ecin520.api.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author NICE
 */
@Data
public class Permission implements Serializable {
	private Integer id;
	private String permissionName;
	private String permissionDescribe;
}
