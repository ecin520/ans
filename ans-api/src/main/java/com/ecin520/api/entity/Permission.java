package com.ecin520.api.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author ecin520
 */
@Data
@Accessors(chain = true)
public class Permission implements Serializable {
	private Integer id;
	private String permission_name;
	private String permission_describe;
}
