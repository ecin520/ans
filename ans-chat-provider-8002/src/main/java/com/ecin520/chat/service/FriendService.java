package com.ecin520.chat.service;

import com.ecin520.api.entity.Friend;
import com.ecin520.api.entity.User;

import java.util.List;

/**
 * @author: ecin520
 * @date: 2019/12/1 17:06
 */
public interface FriendService {
	/**
	 * insert friend
	 * @param friend entity friend
	 * @return Boolean
	 * */
	List<User> insertFriend(Friend friend);

	/**
	 * delete friend by oid
	 * @param sid self id
	 * @param oid other side friend
	 * @return Boolean
	 * */
	Boolean deleteFriendByOid(Integer sid, Integer oid);

	/**
	 * list all your friends
	 * @param sid your id
	 * @return List<Friend>
	 * */
	List<User> listAllFriendsBySid(Integer sid);
}
