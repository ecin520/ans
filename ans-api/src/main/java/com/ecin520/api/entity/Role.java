package com.ecin520.api.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author NICE
 */
@Data
@Accessors(chain = true)
public class Role implements Serializable {
	private Integer id;
	private String role_name;
	private String role_describe;
}
