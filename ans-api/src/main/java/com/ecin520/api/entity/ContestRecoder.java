package com.ecin520.api.entity;

import lombok.Data;

/**
 * @Author: ecin520
 * @Date: 2019/11/29 19:24
 */
@Data
public class ContestRecoder {
	private Integer id;
	private Contest contest;
	private Question question;
	private Integer win_id;
}
