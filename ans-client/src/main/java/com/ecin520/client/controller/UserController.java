package com.ecin520.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.common.JsonObject;
import com.ecin520.api.entity.User;
import com.ecin520.api.service.basic.UserService;
import com.ecin520.client.util.Encryption;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ecin520
 * @Date: 2019/11/28 22:37
 *
 */
@RestController
@RequestMapping("/client/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/insertUser")
    public JSONObject register(@RequestBody User user) {


        user.setPassword(Encryption.md5Encryption(user.getUsername(), user.getPassword()));

        System.out.println(user.getPassword());

        return userService.insertUser(user);
    }

    @RequestMapping("/login")
    public JSONObject login(@RequestParam("username") String username, @RequestParam("password") String password,
                            @RequestParam(value = "remember", defaultValue = "false") Boolean remember) {
        // 实现subject接口
        Subject subject = SecurityUtils.getSubject();

        // 封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, remember);

        // 执行登录,然后这里会跳转到Realm的认证逻辑中
        subject.login(token);

        token.setRememberMe(remember);

        if(subject.isAuthenticated()) {
            return JsonObject.backStatus(200, "登陆成功！");
        } else {
            return JsonObject.backStatus(500, "登陆失败！");
        }
    }

    /**
     * 注销
     * */
    @RequestMapping("/logout")
    public JSONObject logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return JsonObject.backStatus(200, "注销成功！");
    }

    /**
     * 更新用户信息
     * */
    @RequestMapping("/updateUser")
    public JSONObject updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    /**
     * 删除用户
     * */
    @RequestMapping("/deleteUserById")
    @RequiresRoles("admin")
    public JSONObject deleteUserById(@RequestParam("id") Integer id) {
        return userService.deleteUserById(id);
    }

    @RequestMapping("/listAllUsers")
    @RequiresRoles("admin")
    public List<User> listAllUsers() {
        return userService.listAllUsers();
    }

    @RequestMapping("/getUserByUsername")
    public User getUserByUsername(@RequestParam("username") String username) {
        return userService.getUserByUsername(username);
    }

}
