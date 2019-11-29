package com.ecin520.api.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author NICE
 */
@Data
public class Role implements Serializable {
	private Integer id;
	private String role_name;
	private String role_describe;
}
