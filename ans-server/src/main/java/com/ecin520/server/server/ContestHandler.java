package com.ecin520.server.server;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.Contest;
import com.ecin520.api.entity.ContestRecord;
import com.ecin520.api.entity.Question;
import com.ecin520.api.service.answer.ContestService;
import com.ecin520.api.service.answer.QuestionService;
import com.ecin520.server.pojo.Match;
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
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: ecin520
 * @date: 2019/12/15 15:07
 */
@Slf4j
@Component
public class ContestHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

	/**
	 * 用来存放contest请求
	 */
	private static Vector<Match> matchList = new Vector<>();

	/**
	 * 线程安全的自增器
	 */
	public static AtomicInteger idAtom = new AtomicInteger(100);

	/**
	 * 存储channel
	 */
	private static ChannelGroup contestGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

	/**
	 * 每个用户都有指定的ChannelId，通过ChannelId进行通讯
	 */
	private static Map<String, ChannelId> userMap = new ConcurrentHashMap<>();

	/**
	 * 比赛列表Map，一场比赛映射多个比赛记录，当用户匹配成功后，创建一个独一无二的ContestId，存放在
	 * Contest中，然后存放user_a, user_b, type到Contest，同时向数据库拿出五个随机题目，添加到List<ContestRecord>中，
	 * 每次客户端发送指定的index获取题目（从小到大），并且根据用户作答更新List<ContestRecord>中的数据，如果index = 5，
	 * 也就是最后一句，就要统计分数，并且将数据更新到数据库中。
	 * 用户发送匹配连接到匹配到对手到答题到比赛结束过程：
	 * 1.在open中发送自己的id和type{id: userId, type: type}
	 * 2.在onmessage中接收建立连接后的响应，返回的是contest_id，后面答每一道题都要发送这个contest_id来定位
	 * 3.答题时，用户点击选项后，结果发送到后台，再由后台转发到另一个用户上即时渲染
	 */
//	private static Map<Contest, List<ContestRecord>> contestListMap = new ConcurrentHashMap<>();

	private static Set<Contest> contestSet = new CopyOnWriteArraySet<>();

	private static ContestHandler contestHandler;

	@Autowired
	private ContestService contestService;

	@Autowired
	private QuestionService questionService;

	private Boolean flag;

	@PostConstruct
	public void init() {
		contestHandler = this;
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame tsf) throws Exception {

		// 转化为json
		JSONObject jsonObject = JSONObject.parseObject(tsf.text());

		String name = (String) jsonObject.get("name");

		// 发送者id
		Integer sendId = (Integer) jsonObject.get("send_id");

		switch (name) {
			case "search opponent": {


				String type = (String) jsonObject.get("type");

				userMap.put(sendId.toString(), ctx.channel().id());

				flag = false;

				for (int i = 0; i < matchList.size(); i++) {
					// 若Vector中存在待匹配的用户
					if (matchList.get(i).getType().equals(type)) {

						flag = true;
						Contest contest = new Contest();

						contest.setId(idAtom.addAndGet(1));
						contest.setUser_a(matchList.get(i).getUserId());
						contest.setUser_b(sendId);
						contest.setContest_type(type);

						contestSet.add(contest);

						List<Question> questions = questionService.getQuestionsByTypeName(type, 1);

						List<Question> randQues = new ArrayList<>();


						// 添加五道题
						for (int j = 0; j < 5; j++) {
							randQues.add(questions.get(new Random().nextInt(questions.size())));
						}

						JSONObject contestObj = new JSONObject();
						contestObj.put("contest_id", idAtom.get());
						contestObj.put("questions", randQues);
						ctx.writeAndFlush(contestObj.toJSONString());

						matchList.remove(matchList.get(i));
					}
				}

				if (!flag) {
					matchList.addElement(new Match().setUserId(sendId).setType(type));
				}
				break;
			}
			case "matching": {

				String selectItem = (String) jsonObject.get("select_item");

				contestSet.forEach(contest -> {
					if (contest.getUser_a().equals(sendId.toString())) {

						// 另一个客户端更新数据
						contestGroup.find(userMap.get(contest.getUser_b())).writeAndFlush(new TextWebSocketFrame(selectItem));

					}
				});

				break;
			}
			case "result": {

				// 客户端发送过来的比赛记录，规定比赛胜利的一方发送（统计）这个数据，平手则随机
				List<ContestRecord> recordList = (List<ContestRecord>) jsonObject.get("contest_record");

				recordList.forEach(record -> {
					log.info(record.toString());
				});

				break;
			}
			default:
				break;
		}

	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		contestGroup.add(ctx.channel());
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		contestGroup.remove(ctx.channel());
		log.info(ctx.channel().id().asLongText() + " 已退出");
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		contestGroup.add(ctx.channel());
		log.info(ctx.channel().id().asShortText() + "已连接");
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		contestGroup.remove(ctx.channel());
		log.info(ctx.channel().id().asShortText() + "已断开");
	}
}
