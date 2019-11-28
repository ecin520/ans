package com.ecin520.client.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置RestBean
 * */
@Configuration
@ComponentScan
public class RestConfig {

  /**
   * 实现负载均衡
   * AvailabilityFilteringRule : 会先过滤掉跳闸，访问故障的服务，对剩下的进行轮询
   * RoundRobinRule : 轮询
   * RandomRule : 随机
   * RetryRule : 会先按照轮询获取服务，如果服务获取失败，则会在指定的时间内进行重试
   * ......其他负载均衡算法
   * */
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

}
