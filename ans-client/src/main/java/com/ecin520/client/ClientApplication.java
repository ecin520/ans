package com.ecin520.client;

import com.ecin520.client.server.ContestServer;
import com.ecin520.client.server.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ecin520
 * @Date: 2019/11/28 22:34
 */
@SpringBootApplication(scanBasePackages = {"com.ecin520.client","com.ecin520.api"})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.ecin520.api"})
@EnableCaching
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
        nettyServerStart();
        contestServerStart();
    }

    /**
     * chat netty服务器
     * port 8888
     * */
    public static void nettyServerStart() {
        try {
            new NettyServer(8888).serverStart();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * contest netty 服务器
     * port 9999
     * */
    public static void contestServerStart() {
        try {
            new ContestServer(9999).serverStart();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
