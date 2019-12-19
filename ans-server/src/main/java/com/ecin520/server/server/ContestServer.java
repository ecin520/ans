package com.ecin520.server.server;

import com.ecin520.api.service.answer.ContestService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 为了节省运行时的内存空间，把两个Server放到同一个客户端
 * @author: ecin520
 * @date: 2019/12/15 15:07
 */
@Slf4j
public class ContestServer {

	private final Integer PORT;


	public ContestServer(Integer port) {
		this.PORT = port;
	}

	public void serverStart() throws InterruptedException {
		EventLoopGroup mainGroup = new NioEventLoopGroup();
		EventLoopGroup subGroup = new NioEventLoopGroup();

		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(mainGroup, subGroup)
					.channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel socketChannel) throws Exception {
							ChannelPipeline pipeline = socketChannel.pipeline();

							pipeline.addLast(new HttpServerCodec());
							pipeline.addLast(new ChunkedWriteHandler());
							pipeline.addLast(new HttpObjectAggregator(1024*64));
							pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
							pipeline.addLast(new ContestHandler());
						}
					});

			ChannelFuture future = bootstrap.bind(PORT).sync();
			log.info("Contest Netty WebSocket is opening on 9999 port.");
			future.channel().closeFuture().sync();
		} finally {
			mainGroup.shutdownGracefully();
			subGroup.shutdownGracefully();
		}
	}
}
