package cn.com.dxk.springboot.rabbitmq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @Date: 2021/4/22 18:29
 * @Author: DingXingKai
 * @Description:
 */
@RestController
public class TestController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/test")
    public void test() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int priority = random.nextInt(9);
            rabbitTemplate.convertAndSend("testExchange", "testRoutingKey", "msg---" + i + "---priority" + priority, message -> {
                message.getMessageProperties().setPriority(priority);
                message.getMessageProperties().getHeaders().put("msgProducer","abs-prov-receive");
                return message;
            });
        }
    }
}
