package com.ecin520.api.service.chat;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.common.JsonObject;
import com.ecin520.api.entity.Friend;
import com.ecin520.api.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/3 9:30
 */
@Component
@FeignClient(value = "CHAT-PROVIDER")
@RequestMapping("/friend")
public interface FriendService {

    @RequestMapping("/insertFriend")
    JSONObject insertFriend(@RequestBody Friend friend);

    @RequestMapping("/deleteFriend")
    JSONObject deleteFriend(@RequestParam("sid") Integer sid, @RequestParam("oid") Integer oid);

    @RequestMapping("/listAllFriendsBySid")
    List<User> listAllFriendsBySid(@RequestParam("sid") Integer sid);
}
