package com.ecin520.chat.service.impl;

import com.ecin520.api.entity.Chat;
import com.ecin520.api.entity.User;
import com.ecin520.chat.dao.ChatDao;
import com.ecin520.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ecin520
 * @date: 2019/12/1 21:39
 */
@Service
public class ChatServiceImpl implements ChatService {

	private final ChatDao chatDao;

	@Autowired
	public ChatServiceImpl(ChatDao chatDao) {
		this.chatDao = chatDao;
	}

	public Boolean insertChat(Chat chat) {
		return chatDao.insertChat(chat);
	}

	public Boolean updateChat(Chat chat) {
		return chatDao.updateChat(chat);
	}

	public List<User> listAllUsersByReceiveId(Integer receiveId) {
		return chatDao.listAllUsersByReceiveId(receiveId);
	}

	public List<Chat> listChatRecode(Integer sendId, Integer receiveId) {
		return chatDao.listChatRecode(sendId, receiveId);
	}
}