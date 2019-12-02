package com.ecin520.api.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: ecin520
 * @Date: 2019/11/29 19:24
 */
@Data
@Accessors(chain = true)
public class ContestRecord {
	private Integer id;
	private Integer contest_id;
	private Integer question_id;
	private Integer win_id;
}
