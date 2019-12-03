package com.ecin520.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.common.JsonObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ecin520
 * @date: 2019/12/3 17:34
 */
@RestController
public class UnAuthController {

	@RequestMapping("/unauth")
	public JSONObject unauth() {
		return JsonObject.backStatus(404, "请登录！");
	}

}
