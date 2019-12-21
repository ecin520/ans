package com.ecin520.chat.service.impl;

import com.ecin520.api.entity.Chat;
import com.ecin520.api.entity.User;
import com.ecin520.chat.dao.ChatDao;
import com.ecin520.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ecin520
 * @date: 2019/12/1 21:39
 */
@Service
public class ChatServiceImpl implements ChatService {

	@Autowired
	private ChatDao chatDao;

	@Override
	@CachePut(value = "chat", key = "#chat.send_id + ':' + #chat.receive_id")
	public List<Chat> insertChat(Chat chat) {
		chatDao.insertChat(chat);
		return chatDao.listChatRecode(chat.getSend_id(), chat.getReceive_id());
	}

	@Override
	@CachePut(value = "chat", key = "#sendId + ':' + #receiveId")
	public List<Chat> updateChat(Integer sendId, Integer receiveId) {
		chatDao.updateChat(sendId, receiveId);
		return chatDao.listChatRecode(sendId, receiveId);
	}

	@Override
	public List<User> listAllUsersByReceiveId(Integer receiveId) {
		return chatDao.listAllUsersByReceiveId(receiveId);
	}

	@Override
	public List<User> listAllUsersBySelfSendId(Integer userId) {
		return chatDao.listAllUsersBySelfSendId(userId);
	}

	@Override
	@Cacheable(value = "chat", key = "#sendId + ':' + #receiveId")
	public List<Chat> listChatRecode(Integer sendId, Integer receiveId) {
		return chatDao.listChatRecode(sendId, receiveId);
	}

	@Override
	public Integer getUnReadCount(Integer sendId, Integer receiveId) {
		return chatDao.getUnReadCount(sendId, receiveId);
	}

	@Override
	public Chat getLatestChat(Integer sendId, Integer receiveId) {
		return chatDao.getLatestChat(sendId, receiveId);
	}
}
