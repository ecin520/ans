package com.ecin520.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.Chat;
import com.ecin520.api.entity.User;
import com.ecin520.api.service.chat.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: ecin520
 * @date: 2019/12/3 21:49
 */
@RestController
@RequestMapping("/client/chat")
public class ChatController {

	@Autowired
	private ChatService chatService;

	@Autowired
	private UserController userController;

	/**
	 * 发送消息后，首先在 websocket 中进行通讯，然后将 Chat 对象的 send_id receive_id content 封装成 json
	 * 数据发送到后端，保存到数据库保存记录，聊天记录可以通过 send_id 和 receive_id 对应的 content 来查看
	 * */
	@RequestMapping("/insertChat")
	public JSONObject insertChat(@RequestBody Chat chat) {
		return chatService.insertChat(chat);
	}

	/**
	 * 当用户进入 app 时，调用此接口，获取该用户所有的消息列表
	 * */
	@RequestMapping("/listAllUsersByReceiveId")
	public List<User> listAllUsersByReceiveId(@RequestParam("receiveId") Integer receiveId) {
		return chatService.listAllUsersByReceiveId(receiveId);
	}

	@RequestMapping("/listAllUsersBySendId")
	public List<User> listAllUsersBySelfSendId(@RequestParam("userId") Integer userId) {
		return chatService.listAllUsersBySelfSendId(userId);
	}


	/**
	 * 查看指定用户的聊天记录
	 * send_id 为自己 id receive_id 为对方 id 时获取的是自己给对方发送的消息
	 * send_id 为对方 id receive_id 为自己 id 时获取的时对方给自己发送的消息
	 * 同时更新聊天状态
	 * @param receiveId  receiveId
	 * @param sendId  sendId
	 * @return List<Chat>
	 * */
	@RequestMapping("/listChatRecode")
	public List<Chat> listChatRecode(@RequestParam("sendId") Integer sendId, @RequestParam("receiveId") Integer receiveId, @RequestParam("role") String role) {
		return chatService.listChatRecode(sendId, receiveId, role);
	}

	/**
	 * 查看未读消息
	 * @param sendId sendID
	 * @param receiveId receiveID
	 * @return Integer
	 * */
	@RequestMapping("/getUnReadCount")
	public Integer getUnReadCount(@RequestParam("sendId") Integer sendId, @RequestParam("receiveId") Integer receiveId) {
		return chatService.getUnReadCount(sendId, receiveId);
	}


	/**
	 * 获取最新的消息记录，用于放在列表页面
	 * @param sendId sendId
	 * @param receiveId receiveId
	 * @return Chat
	 * */
	@RequestMapping("/getLatestChat")
	public Chat getLatestChat(@RequestParam("sendId") Integer sendId, @RequestParam("receiveId") Integer receiveId) {
		// 获取对方发的最新聊天记录
		Chat otherChat = chatService.getLatestChat(sendId, receiveId);
		// 获取自己发地最新聊天记录
		Chat selfChat = chatService.getLatestChat(receiveId, sendId);

		if (otherChat == null) {
			return selfChat;
		}
		if (selfChat == null) {
			return otherChat;
		}

		if (selfChat.getTime().compareTo(otherChat.getTime()) > 0) {
			return selfChat;
		} else {
			return otherChat;
		}
	}

}
