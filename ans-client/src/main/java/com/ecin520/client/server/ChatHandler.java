package com.ecin520.client.server;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.Chat;
import com.ecin520.api.service.chat.ChatService;
import com.ecin520.client.util.FinalValue;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ecin520
 * @date: 2019/12/11 10:24
 */
@Slf4j
@Component
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    /**
     * 一个userId对应一个ChannelId,通过ChannelId可以定位对应的Channel
     * */
    private static Map<String, ChannelId> userMap = new ConcurrentHashMap<>();

    @Autowired
    private ChatService chatService;

    private static ChatHandler chatHandler;

    @PostConstruct
    public void init() {
        chatHandler = this;
    }

    /**
     * status状态信息
     * 1 在线
     * 2 第一次连接
     *
     * */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame tsf) throws Exception {

        // 将Json String转化为Json
        JSONObject jsonObject = JSONObject.parseObject(tsf.text());


        String sendId = jsonObject.getString("sendId");
        String receiveId = jsonObject.getString("receiveId");
        String content = jsonObject.getString("content");
        String status = jsonObject.getString("status");



        // 如果刚登录，客户端自动发送一条数据到服务端，同时保存用户id和对应的ChannelId
        if ("2".equals(status)) {
            log.info(sendId+"进入,将id与channel id进行k-v存储");
            userMap.put(sendId, ctx.channel().id());
            ctx.channel().writeAndFlush("连接服务器成功");
        } else if ("1".equals(status)) {
            JSONObject toClient = new JSONObject();
            toClient.put("sendId", sendId);
            toClient.put("receiveId", receiveId);
            toClient.put("content", content);

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            toClient.put("sendTime", df.format(new Date()));

            // 将会话存储至数据库
            Chat chat = new Chat();
            chat.setSend_id(Integer.parseInt(sendId));
            chat.setReceive_id(Integer.parseInt(receiveId));
            chat.setContent(content);
            chat.setTime(df.format(new Date()));

            chatHandler.chatService.insertChat(chat);

            clients.find(userMap.get(receiveId)).writeAndFlush(new TextWebSocketFrame(toClient.toJSONString()));
        }


//        clients.forEach((client) -> {
//            client.writeAndFlush(new TextWebSocketFrame(tsf.text()));
//        });
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        clients.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        clients.remove(ctx.channel());
        log.info(ctx.channel().id().asLongText() + " 已退出");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        clients.add(ctx.channel());
        log.info(ctx.channel().id().asShortText() + "已连接");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        clients.remove(ctx.channel());
        log.info(ctx.channel().id().asShortText() + "已断开");
    }
}
