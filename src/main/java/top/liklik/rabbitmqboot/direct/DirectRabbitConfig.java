package top.liklik.rabbitmqboot.direct;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitConfig {
    private final static String DIRECT_QUEUE_ONE = "direct_queue_one";
    private final static String DIRECT_QUEUE_TWO = "direct_queue_two";
    public final static String DIRECTEXCHANGE = "mybootDirectExchange";

    @Bean
    public Queue directQueueOne() {
        return new Queue(DIRECT_QUEUE_ONE);
    }

    @Bean
    public Queue directQueueTwo() {
        return new Queue(DIRECT_QUEUE_TWO);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECTEXCHANGE);
    }

    @Bean
    Binding directBindingOne(Queue directQueueOne, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueueOne).to(directExchange).with("type1");
    }

    @Bean
    Binding directBindingTwo(Queue directQueueTwo, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueueTwo).to(directExchange).with("type2");
    }
}
