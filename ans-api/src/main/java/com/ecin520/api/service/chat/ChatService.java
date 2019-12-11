package com.ecin520.api.service.chat;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.Chat;
import com.ecin520.api.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/3 9:28
 */
@Component
@FeignClient(value = "CHAT-PROVIDER")
@RequestMapping("/chat")
public interface ChatService {

    /**
     * 发送消息后，首先在 websocket 中进行通讯，然后将 Chat 对象的 send_id receive_id content 封装成 json
     * 数据发送到后端，保存到数据库保存记录，聊天记录可以通过 send_id 和 receive_id 对应的 content 来查看
     * */
    @RequestMapping("/insertChat")
    JSONObject insertChat(@RequestBody Chat chat);

    /**
     * 当用户进入 app 时，调用此接口，获取该用户所有的消息列表
     * */
    @RequestMapping("/listAllUsersByReceiveId")
    List<User> listAllUsersByReceiveId(@RequestParam("receiveId") Integer receiveId);


    @RequestMapping("/listAllUsersBySendId")
    List<User> listAllUsersBySelfSendId(@RequestParam("userId") Integer userId);

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
    List<Chat> listChatRecode(@RequestParam("sendId") Integer sendId, @RequestParam("receiveId") Integer receiveId, @RequestParam("role") String role);

    @RequestMapping("/getUnReadCount")
    Integer getUnReadCount(@RequestParam("sendId") Integer sendId, @RequestParam("receiveId") Integer receiveId);

    /**
     * 获取最新的消息记录，用于放在列表页面
     * @param sendId sendId
     * @param receiveId receiveId
     * @return Chat
     * */
    @RequestMapping("/getLatestChat")
    Chat getLatestChat(@RequestParam("sendId") Integer sendId, @RequestParam("receiveId") Integer receiveId);
}
