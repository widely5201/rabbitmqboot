package top.liklik.rabbitmqboot.FanoutRabbitConfig;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {
    private final static String FANOUT_QUEUE_ONE = "fanout_queue_one";
    private final static String FANOUT_QUEUE_TWO = "fanout_queue_two";

    @Bean
    public Queue fanoutOne() {
        return new Queue(FANOUT_QUEUE_ONE);
    }

    @Bean
    public Queue fanoutTwo() {
        return new Queue(FANOUT_QUEUE_TWO);
    }

    @Bean
    FanoutExchange mybootFanoutExchange() {
        return new FanoutExchange("mybootFanoutExchange");
    }

    @Bean
    Binding bindingOne(Queue fanoutOne, FanoutExchange mybootFanoutExchange) {
        return BindingBuilder.bind(fanoutOne).to(mybootFanoutExchange);
    }

    @Bean
    Binding bindingTwo(Queue fanoutTwo, FanoutExchange mybootFanoutExchange) {
        return BindingBuilder.bind(fanoutTwo).to(mybootFanoutExchange);
    }

}
