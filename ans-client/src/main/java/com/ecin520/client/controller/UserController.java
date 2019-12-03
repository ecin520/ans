package com.ecin520.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.common.JsonObject;
import com.ecin520.api.entity.User;
import com.ecin520.api.service.basic.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ecin520
 * @Date: 2019/11/28 22:37
 *
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    @RequestMapping("/login")
//    public JSONObject login(@RequestParam("username") String username) {
//
//        User user = userService.getUserByUsername(username);
//
//        return JsonObject.backStatus(200, "登陆成功！");
//
//    }
}
