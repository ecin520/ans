package com.ecin520.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ecin520
 * @Date: 2019/11/28 22:34
 */
@SpringBootApplication(scanBasePackages = {"com.ecin520.client","com.ecin520.api"})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.ecin520.api"})
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }
}
