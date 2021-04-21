package org.dxk.springcloud.alibaba;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Date: 2021/4/21 20:27
 * @Author: DingXingKai
 * @Description:
 */
@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        try {
            ConfigurableApplicationContext applicationContext = SpringApplication.run(GatewayApplication.class, args);
            ConfigurableEnvironment environment = applicationContext.getEnvironment();
            MutablePropertySources propertySources = environment.getPropertySources();
            log.info("当前应用运行环境信息：ip ------------> {}" , InetAddress.getLocalHost().getHostAddress());
            log.info("当前应用运行环境信息：port ----------> {}" ,environment.getProperty("server.port"));
            log.info("当前应用运行环境信息：ap-name -------> {}" ,environment.getProperty("spring.application.name"));
        } catch (UnknownHostException e) {
            log.error("微服务网关启动异常：{}", e.getMessage());
        }
    }
}
