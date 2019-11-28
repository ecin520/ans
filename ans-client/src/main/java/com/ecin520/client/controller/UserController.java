package com.ecin520.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.User;
import com.ecin520.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ecin520
 * @Date: 2019/11/28 22:37
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/fuck")
    public List<User> fuck() {
        return userService.listAllUsers();
    }
}
