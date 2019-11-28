package com.ecin520.api.common;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: ecin520
 * @Date: 2019/11/28 16:27
 */
public class JsonObject {

	public static JSONObject backStatus( Integer statusCode, String message) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status code", statusCode);
		jsonObject.put("message", message);
		return jsonObject;
	}

}
