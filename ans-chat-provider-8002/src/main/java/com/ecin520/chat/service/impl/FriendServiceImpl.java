package com.ecin520.chat.service.impl;

import com.ecin520.api.entity.Friend;
import com.ecin520.api.entity.User;
import com.ecin520.chat.dao.FriendDao;
import com.ecin520.chat.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ecin520
 * @date: 2019/12/1 17:06
 */
@Service
public class FriendServiceImpl implements FriendService {

	private FriendDao friendDao;

	@Autowired
	public FriendServiceImpl(FriendDao friendDao) {
		this.friendDao = friendDao;
	}

	public Boolean insertFriend(Friend friend) {
		return friendDao.insertFriend(friend);
	}

	public Boolean deleteFriendByOid(Integer sid, Integer oid) {
		return friendDao.deleteFriendByOid(sid, oid);
	}

	public List<User> listAllFriendsBySid(Integer sid) {
		return friendDao.listAllFriendsBySid(sid);
	}
}
