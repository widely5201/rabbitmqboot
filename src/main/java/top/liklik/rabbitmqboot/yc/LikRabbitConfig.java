package top.liklik.rabbitmqboot.yc;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


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
