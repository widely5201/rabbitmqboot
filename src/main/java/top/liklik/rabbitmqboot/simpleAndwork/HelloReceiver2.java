package top.liklik.rabbitmqboot.simpleAndwork;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "q_hello")
public class HelloReceiver2 {
    @RabbitHandler
    public void process(String hello) {
        System.out.println(" HelloReceiver2  : " + hello);
    }
}
