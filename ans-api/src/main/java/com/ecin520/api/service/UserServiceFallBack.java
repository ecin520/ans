package com.ecin520.api.service;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ecin520
 * @Date: 2019/11/28 20:04
 */
@Component
public class UserServiceFallBack implements FallbackFactory<UserService> {
    public UserService create(Throwable throwable) {
        return new UserService() {

            public JSONObject insertUser(User user) {
                return null;
            }

            public List<User> listAllUsers() {
                return null;
            }

            public User getUserByUsername(String username) {
                return null;
            }
        };
    }
}
