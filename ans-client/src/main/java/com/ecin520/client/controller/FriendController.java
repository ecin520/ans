package com.ecin520.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.common.JsonObject;
import com.ecin520.api.entity.Friend;
import com.ecin520.api.entity.User;
import com.ecin520.api.service.chat.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: ecin520
 * @date: 2019/12/3 21:52
 */
@RestController
@RequestMapping("/client/friend")
public class FriendController {

	@Autowired
	private FriendService friendService;

	@RequestMapping("/insertFriend")
	public JSONObject insertFriend(@RequestBody Friend friend) {
		return friendService.insertFriend(friend);
	}

	@RequestMapping("/deleteFriend")
	public JSONObject deleteFriend(@RequestParam("sid") Integer sid, @RequestParam("oid") Integer oid) {
		return friendService.deleteFriend(sid, oid);
	}

	@RequestMapping("/listAllFriendsBySid")
	public List<User> listAllFriendsBySid(@RequestParam("sid") Integer sid) {
		return friendService.listAllFriendsBySid(sid);
	}

}
