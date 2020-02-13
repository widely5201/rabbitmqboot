package top.liklik.rabbitmqboot.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "q_topic_messages")
public class Receiver2 {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("TopicReceiver2 : " + hello);
    }
}
