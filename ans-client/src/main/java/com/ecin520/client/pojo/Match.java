package com.ecin520.client.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: ecin520
 * @date: 2019/12/15 17:53
 */
@Data
@Accessors(chain = true)
public class Match {
	private String type;
	private Integer userId;
}
