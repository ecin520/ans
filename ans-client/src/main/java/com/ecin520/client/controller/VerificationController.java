package com.ecin520.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.Friend;
import com.ecin520.api.entity.User;
import com.ecin520.api.entity.Verification;
import com.ecin520.api.service.basic.UserService;
import com.ecin520.api.service.chat.FriendService;
import com.ecin520.api.service.chat.VerificationService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ecin520
 * @date: 2019/12/3 21:56
 */
@RestController
@RequestMapping("/client/verification")
public class VerificationController {

	private final VerificationService verificationService;

	private final FriendService friendService;

	private final UserService userService;

	@Autowired
	public VerificationController(VerificationService verificationService, FriendService friendService, UserService userService) {
		this.verificationService = verificationService;
		this.friendService = friendService;
		this.userService = userService;
	}


	/**
	 * 当用户点击添加好友后，将 send_id 和 receive_id 发送到后台，后台自动设定认证状态为 3（未验证）,
	 * 每当用户进入app，都会发送请求服务端是否有人要添加其为好友，若存在一个 receive_id 为自己且 ver_status 为 3 的字段，就渲染到客户端
	 * SELECT `username` FROM `user` WHERE `id` IN ( SELECT `send_id` FROM `verification` WHERE `receive_id` = #{id} AND `ver_status` = 3 );
	 * 检查自己是否有人添加
	 * */
	@RequestMapping("/insertVerification")
	@RequiresRoles("normal user")
	@CrossOrigin
	public JSONObject insertVerification(@RequestBody Verification verification) {

		// 将状态设置为未验证
		verification.setVer_status(3);

		return verificationService.insertVerification(verification);

	}

	/**
	 * 当用户点击同意添加好友后，就将双方互相添加为好友
	 * 前端数据要求 1 同意添加好友 2 不同意添加好友 3 未处理的验证
	 * */
	@RequestMapping("/updateVerificationsStatus")
	@RequiresRoles("normal user")
	@CrossOrigin
	public JSONObject updateVerificationsStatus(@RequestBody Verification verification) {

		if ( 1 == verification.getVer_status() ) {
			friendService.insertFriend( new Friend().setSid( verification.getSend_id() ).setOid( verification.getReceive_id() ) );
			friendService.insertFriend( new Friend().setSid( verification.getReceive_id() ).setOid( verification.getSend_id() ) );
		}
		return verificationService.updateVerificationsStatus(verification);

	}


	/**
	 * 用户登录后需要请求的接口，查询其是否有人添加为好友
	 * 通过 receive_id 为当前用户来返回 Verification 数据
	 * @param id 用户的id
	 */
	@RequestMapping("/listUserUnverified")
	@RequiresRoles("normal user")
	@CrossOrigin
	public List<User> listUserUnverified(@RequestParam("id") Integer id) {

		List<Verification> verificationList = verificationService.listUserUnverified(id);
		List<User> userList = new ArrayList<>();

		verificationList.forEach(verification -> {
			User user = userService.getUserById(verification.getSend_id());
			user.setPassword(null);
			userList.add(user);
		});

		return userList;
	}

}
