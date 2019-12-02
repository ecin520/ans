package com.ecin520.chat.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.common.JsonObject;
import com.ecin520.api.entity.Chat;
import com.ecin520.api.entity.User;
import com.ecin520.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: ecin520
 * @date: 2019/12/1 21:39
 */
@RestController
@RequestMapping("/chat")
public class ChatController {

	private ChatService chatService;

	@Autowired
	public ChatController(ChatService chatService) {
		this.chatService = chatService;
	}


	/**
	 * 发送消息后，首先在 websocket 中进行通讯，然后将 Chat 对象的 send_id receive_id content 封装成 json
	 * 数据发送到后端，保存到数据库保存记录，聊天记录可以通过 send_id 和 receive_id 对应的 content 来查看
	 * */
	@RequestMapping("/insertChat")
	public JSONObject insertChat(@RequestBody Chat chat) {
		if (chatService.insertChat(chat)) {
			return JsonObject.backStatus(200, "发送成功！");
		} else {
			return JsonObject.backStatus(500, "发送失败！");
		}
	}

	/**
	 * 当用户进入 app 时，调用此接口，获取该用户所有的消息列表
	 * */
	@RequestMapping("/listAllUsersByReceiveId")
	public List<User> listAllUsersByReceiveId(@RequestParam("receiveId") Integer receiveId) {
		return chatService.listAllUsersByReceiveId(receiveId);
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
	public List<Chat> listChatRecode(@RequestParam("sendId") Integer sendId, @RequestParam("receiveId") Integer receiveId) {
		// 更新消息的状态信息
		chatService.updateChat(sendId, receiveId);
		// 返回消息列表
		return chatService.listChatRecode(sendId, receiveId);
	}


	/**
	 * 获取最新的消息记录，用于放在列表页面
	 * @param sendId sendId
	 * @param receiveId receiveId
	 * @return Chat
	 * */
	@RequestMapping("/getLatestChat")
	public Chat getLatestChat(@RequestParam("sendId") Integer sendId, @RequestParam("receiveId") Integer receiveId) {
		return chatService.getLatestChat(sendId, receiveId);
	}




}
