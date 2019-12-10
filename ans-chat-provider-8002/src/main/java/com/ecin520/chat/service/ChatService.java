package com.ecin520.chat.service;

import com.ecin520.api.entity.Chat;
import com.ecin520.api.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author: ecin520
 * @date: 2019/12/1 21:38
 */
public interface ChatService {

	/**
	 * 插入聊天记录
	 * @param chat 聊天信息
	 * @return Boolean
	 * */
	Boolean insertChat(Chat chat);

	/**
	 * 更新聊天，将状态更改为 1 ，表示已读
	 * 3 ：未读
	 * 1 ：已读
	 * @param sendId sendId
	 * @param receiveId receiveId
	 * @return Boolean
	 * */
	Boolean updateChat(Integer sendId, Integer receiveId);

	/**
	 * 通过 receiveId 查找本用户所有的消息列表的用户，chat结构为{"send_id": *, "receive_id": *}
	 * @param receiveId 也就是自己的id
	 * @return List<User>
	 * */
	List<User> listAllUsersByReceiveId(Integer receiveId);

	/**
	 * 通过自己的id获取已发送的列表
	 * @param userId 自己的id
	 * @return List<User>
	 * */
	List<User> listAllUsersBySelfSendId(@RequestParam("userId") Integer userId);

	/**
	 * 通过 send_id receive_id 获取相互之间的聊天记录
	 * @param receiveId 接收者id
	 * @param sendId 发送者id
	 * @return List<Chat>
	 * */
	List<Chat> listChatRecode(Integer sendId, Integer receiveId);

	/**
	 * 获取最新的消息记录，用于放在列表页面
	 * @param sendId sendId
	 * @param receiveId receiveId
	 * @return Chat
	 * */
	Chat getLatestChat(Integer sendId, Integer receiveId);
}
