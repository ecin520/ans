package com.ecin520.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.common.JsonObject;
import com.ecin520.api.entity.Role;
import com.ecin520.api.entity.User;
import com.ecin520.api.entity.UserRole;
import com.ecin520.api.service.basic.UserRoleService;
import com.ecin520.api.service.basic.UserService;
import com.ecin520.client.util.Encryption;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("/insertUser")
    public JSONObject register(@RequestBody User user) {

        user.setPassword(Encryption.md5Encryption(user.getUsername(), user.getPassword()));

        System.out.println(user.getPassword());

        JSONObject object = userService.insertUser(user);

        Integer userId = userService.getUserByUsername(user.getUsername()).getId();

        // 107为数据库中普通用户权限
        userRoleService.insertUserRole(userId, 107);

        return object;

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
    @RequiresPermissions("highest permission")
    @RequestMapping("/updateUser")
    @CrossOrigin
    public JSONObject updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @RequiresRoles("normal user")
    @RequestMapping("/updateUserByNorUser")
    @CrossOrigin
    public JSONObject updateUserByNorUser(@RequestBody User user) {

        User iuser = userService.getUserById(user.getId());

        iuser.setNickname(user.getNickname());
        iuser.setTel_number(user.getTel_number());
        iuser.setSign(user.getSign());
        iuser.setAvatar_url(user.getAvatar_url());

        return userService.updateUser(iuser);
    }

    /**
     * 删除用户
     * */
    @RequestMapping("/deleteUserById")
    @RequiresPermissions("highest permission")
    public JSONObject deleteUserById(@RequestParam("id") Integer id) {
        return userService.deleteUserById(id);
    }

    @RequestMapping("/listAllUsers")
    @RequiresPermissions("highest permission")
    public List<User> listAllUsers() {
        return userService.listAllUsers();
    }

    @RequestMapping("/listUsersByNorPer")
    @RequiresRoles("normal user")
    public List<User> listUsersByDevote() {
        List<User> userList = userService.listAllUsers();
        for (int i = 0; i < userList.size(); i++) {
            userList.get(i).setPassword(null);
            userList.get(i).setStatus(null);
            userList.get(i).setTel_number(null);
        }
        return userList;
    }

    @RequestMapping("/getUserByUsername")
    @RequiresRoles("normal user")
    public User getUserByUsername(@RequestParam("username") String username) {
        return userService.getUserByUsername(username);
    }

    @RequestMapping("/getUserById")
    @RequiresRoles("normal user")
    public User getUserById(@RequestParam("id") Integer id) {
        return userService.getUserById(id);
    }


    @RequestMapping("/addExperience")
    @RequiresRoles("normal user")
    public JSONObject addExperience(@RequestParam("userId") Integer userId, @RequestParam("exp") Integer exp) {
        User user = userService.getUserById(userId);

        if (exp >  10) {
            return JsonObject.backStatus(500, "请勿破坏游戏规则！违者封号！");
        }

        System.out.println(user.getRank());
        System.out.println(exp);

        return (userService.addExperience(userId, user.getRank() + exp));
    }
}
