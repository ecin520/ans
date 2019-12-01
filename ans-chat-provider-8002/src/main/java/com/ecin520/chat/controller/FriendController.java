package com.ecin520.chat.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.common.JsonObject;
import com.ecin520.api.entity.Friend;
import com.ecin520.api.entity.User;
import com.ecin520.chat.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: ecin520
 * @date: 2019/12/1 17:08
 */
@RestController
@RequestMapping("/friend")
public class FriendController {

	private FriendService friendService;

	@Autowired
	public FriendController(FriendService friendService) {
		this.friendService = friendService;
	}

	@RequestMapping("/insertFriend")
	public JSONObject insertFriend(@RequestBody Friend friend) {
		if (friendService.insertFriend(friend)) {
			return JsonObject.backStatus(200, "添加好友成功！");
		} else {
			return JsonObject.backStatus(500, "添加好友失败！");
		}
	}

	@RequestMapping("/deleteFriend")
	public JSONObject deleteFriend(@RequestParam("sid") Integer sid, @RequestParam("oid") Integer oid) {
		if (friendService.deleteFriendByOid(sid, oid)) {
			return JsonObject.backStatus(200, "删除好友成功！");
		} else {
			return JsonObject.backStatus(500, "删除好友失败！");
		}
	}

	@RequestMapping("/listAllFriendsBySid")
	public List<User> listAllFriendsBySid(@RequestParam("sid") Integer sid) {
		return friendService.listAllFriendsBySid(sid);
	}
}
