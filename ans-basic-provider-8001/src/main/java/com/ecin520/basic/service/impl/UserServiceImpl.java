package com.ecin520.basic.service.impl;

import com.ecin520.api.entity.User;
import com.ecin520.basic.dao.UserDao;
import com.ecin520.basic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author NICE
 * @Date: 2019/11/28 10:44
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public Boolean insertUser(User user) {
        return userDao.insertUser(user);
    }

    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    public List<User> listAllUsers() {
        return userDao.listAllUsers();
    }

    public Boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    public Boolean deleteUserById(Integer id) {
        return userDao.deleteUserById(id);
    }
}
