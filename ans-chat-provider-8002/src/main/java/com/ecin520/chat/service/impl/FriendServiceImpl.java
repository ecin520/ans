package com.ecin520.chat.service.impl;

import com.ecin520.api.entity.Friend;
import com.ecin520.api.entity.User;
import com.ecin520.chat.dao.FriendDao;
import com.ecin520.chat.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ecin520
 * @date: 2019/12/1 17:06
 */
@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	private FriendDao friendDao;

	@Override
	@CachePut(value = "friend", key = "#friend.sid")
	public List<User> insertFriend(Friend friend) {
		friendDao.insertFriend(friend);
		return friendDao.listAllFriendsBySid(friend.getSid());
	}

	@Override
	@Cacheable(value = "friend", key = "#friend.sid")
	public Boolean deleteFriendByOid(Integer sid, Integer oid) {
		return friendDao.deleteFriendByOid(sid, oid);
	}

	@Override
	@CachePut(value = "friend", key = "#friend.sid")
	public List<User> listAllFriendsBySid(Integer sid) {
		return friendDao.listAllFriendsBySid(sid);
	}
}
