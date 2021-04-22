package cn.com.dxk.springboot.rabbitmq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Date: 2021/4/22 18:35
 * @Author: DingXingKai
 * @Description:
 */
@Component
public class TestListener {

    @RabbitListener(queues = "testQueue")
    public void testListener(Message message) throws InterruptedException {
        //Thread.sleep(100000000);
        String msgContent = new String(message.getBody());
        System.out.println(msgContent);
    }
}
