package com.ecin520.api.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: ecin520
 * @Date: 2019/11/29 19:22
 */
@Data
@Accessors(chain = true)
public class Contest {
	private Integer id;
	private User user_a;
	private User user_b;
	private Integer win_id;
	private String contest_time;
}
