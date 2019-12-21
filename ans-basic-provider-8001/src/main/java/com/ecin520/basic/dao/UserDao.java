package com.ecin520.basic.dao;

import com.ecin520.api.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author NICE
 * @Date: 2019/11/28 10:41
 */
@Mapper
public interface UserDao {
    /**
     * it triggers when user register the account
     * @param user is the param by user to commit
     * @return {true} if insert succcessfully, {false} when fail
     * */
    Boolean insertUser(User user);

    /**
     * Querying user by id
     * @param id user's id
     * @return {user} when not null
     * */
    User getUserById(Integer id);

    /**
     * Querying user by username
     * @param username user's id
     * @return {user} when not null
     * */
    User getUserByUsername(String username);

    /**
    * list all users
    * @return List<Users>
    * */
    List<User> listAllUsers();

    /**
     * update user's information
     * @param user user
     * @return true or false
     * */
    Boolean updateUser(User user);

    /**
     * delete user by id
     * @param id user's id
     * @return true or false
     * */
    Boolean deleteUserById(Integer id);

    /**
     * 增加经验
     * @param userId userId
     * @param rank rank
     * @return Boolean
     * */
    Boolean addExperience(Integer userId, Integer rank);

}
