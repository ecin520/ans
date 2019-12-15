package com.ecin520.client.server;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.Contest;
import com.ecin520.api.entity.ContestRecord;
import com.ecin520.api.service.answer.ContestService;
import com.ecin520.api.service.chat.ChatService;
import com.ecin520.client.pojo.Match;
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
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: ecin520
 * @date: 2019/12/15 15:07
 */
@Slf4j
@Component
public class ContestHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

	/**
	 * 用来存放contest请求
	 * */
	private static Vector<Match> matchList = new Vector<>();

	/**
	 * 存储channel
	 * */
	private static ChannelGroup contestGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

	/**
	 * 每个用户都有指定的ChannelId，通过ChannelId进行通讯
	 * */
	private static Map<String, ChannelId> userMap = new ConcurrentHashMap<>();

	/**
	 * 比赛列表Map，一场比赛映射多个比赛记录，当用户匹配成功后，创建一个独一无二的ContestId，存放在
	 * Contest中，然后存放user_a, user_b, type到Contest，同时向数据库拿出五个随机题目，添加到List<ContestRecord>中，
	 * 每次客户端发送指定的index获取题目（从小到大），并且根据用户作答更新List<ContestRecord>中的数据，如果index = 5，
	 * 也就是最后一句，就要统计分数，并且将数据更新到数据库中。
	 * 用户发送匹配连接到匹配到对手到答题到比赛结束过程：
	 * 1.在open中发送自己的id和type{id: userId, type: type}
	 * 2.在onmessage中接收建立连接后的响应，返回的是contest_id
	 * */
	private static Map<Contest, List<ContestRecord>> contestListMap = new ConcurrentHashMap<>();

	private static ContestHandler contestHandler;

	@Autowired
	private ContestService contestService;


	@PostConstruct
	public void init() {
		contestHandler = this;
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame tsf) throws Exception {

		// 转化为json
		JSONObject jsonObject = JSONObject.parseObject(tsf.text());

		String name = (String) jsonObject.get("name");

		switch (name) {
			case "search opponent": {
				Integer sendId = (Integer) jsonObject.get("send_id");
				String type = (String) jsonObject.get("type");

				Boolean flag = false;

				for (int i = 0; i < matchList.size(); i++) {
					// 若Vector中存在待匹配的用户
					if (matchList.get(i).getType().equals(type)) {
						flag = true;
						Contest contest = new Contest();
						contest.setUser_a(sendId);
						contest.setUser_b(matchList.get(i).getUserId());
						contest.setContest_type(type);

						contestService.insertContest(contest);

						matchList.remove(matchList.get(i));
					}
				}

				if (!flag) {
					matchList.addElement(new Match().setUserId(sendId).setType(type));
				}
				break;
			}
			case "contest": {

			}
			default:
				break;
		}


	}
}
