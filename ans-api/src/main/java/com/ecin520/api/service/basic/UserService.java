package com.ecin520.api.service.basic;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/3 9:03
 */
@Component
@FeignClient(value = "BASIC-PROVIDER")
@RequestMapping("/user")
public interface UserService {

    @RequestMapping("/insertUser")
    JSONObject insertUser(@RequestBody User user);


    @RequestMapping("/updateUser")
    JSONObject updateUser(@RequestBody User user);


    @RequestMapping("/deleteUserById")
    JSONObject deleteUserById(@RequestParam("id") Integer id);

    @RequestMapping("/listAllUsers")
    List<User> listAllUsers();

    @RequestMapping("/getUserByUsername")
    User getUserByUsername(@RequestParam("username") String username);
}
