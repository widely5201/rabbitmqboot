package top.liklik.rabbitmqboot.yc;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


/**
 * 延迟消息队列实现原理：
 * TTL（Time to live）消息通过交换器到达死信队列，当死信队列没有消费者消费该条消息，并且到达消息失效时间，会转发消息到死信路由，
 * 死信路由再将消息发送到绑定的消息队列上去供消费者消费
 */
@Configuration
public class LikRabbitConfig {

    /**
     * 死信队列
     * @return
     */
    @Bean
    public Queue likqueue() {
        Map<String, Object> map = new HashMap<>();
        map.put("x-dead-letter-exchange", "ttlExchange");
        map.put("x-dead-letter-routing-key","ttl_forward");
        return QueueBuilder.durable("lik_ttl").withArguments(map).build();
    }

    @Bean
    public Queue normalQueue() {
        return new Queue("normalQueue");
    }

    /**
     * 死信路由
     * @return
     */
    @Bean
    public DirectExchange ttlExchange() {
        return new DirectExchange("ttlExchange");
    }

    @Bean
    public DirectExchange normalExchange() {
        return new DirectExchange("normalExchange");
    }

    @Bean
    Binding ttlBinding() {
        return BindingBuilder.bind(likqueue()).to(normalExchange()).with("lik_ttl_key");
    }

    @Bean
    Binding forwardBinding() {
        return BindingBuilder.bind(normalQueue()).to(ttlExchange()).with("ttl_forward");
    }
}
