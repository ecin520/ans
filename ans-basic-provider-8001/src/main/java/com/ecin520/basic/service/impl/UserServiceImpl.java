package com.ecin520.basic.service.impl;

import com.ecin520.api.entity.User;
import com.ecin520.basic.dao.UserDao;
import com.ecin520.basic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    @Override
    public Boolean insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public List<User> listAllUsers() {
        return userDao.listAllUsers();
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user) ? user : null;
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public Boolean addExperience(Integer userId, Integer rank) {
        return userDao.addExperience(userId, rank);
    }
}
