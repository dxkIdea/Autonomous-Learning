package cn.com.dxk.springboot.rabbitmq.conf;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date: 2021/4/22 18:31
 * @Author: DingXingKai
 * @Description:
 */
@Configuration
public class RabbitMqConf {
    /**
     * 声明正常队列交换机
     * @return
     */
    @Bean("testExchange")
    public DirectExchange provLevelProcessExchange(){
        return new DirectExchange("testExchange");
    }

    /**
     * 声明队列
     * @return
     */
    @Bean("testQueue")
    public Queue testQueue() {
        Map<String, Object> arguments = new HashMap<>(1);
        arguments.put("x-max-priority", 9);
        return new Queue("testQueue", true,false,false,arguments);
    }

    /**
     * 交换机通过routingKey绑定队列
     * @param queue 测试队列
     * @param exchange 交换机
     * @return
     */
    @Bean
    public Binding bindingProvLevelProcessFirstQueue(@Qualifier("testQueue") Queue queue,
                                                     @Qualifier("testExchange") DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("testRoutingKey");
    }
}
