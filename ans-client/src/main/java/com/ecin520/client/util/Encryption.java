package com.ecin520.client.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 密码加密工具
 * @author: ecin520
 * @date: 2019/12/3 17:10
 */
public class Encryption {
	public static String md5Encryption(String username, String password){
		return new SimpleHash
				("MD5", password, ByteSource.Util.bytes
						(username), 3).toHex();
	}
}
