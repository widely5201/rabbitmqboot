package top.liklik.rabbitmqboot.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "direct_queue_two")
public class DirectReceiver2 {
    @RabbitHandler
    public void msg(String msg) {
        System.out.println(" DirectReceiver2 : " + msg);
    }
}
