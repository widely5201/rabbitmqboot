package top.liklik.rabbitmqboot.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "direct_queue_one")
public class DirectReceiver1 {
    @RabbitHandler
    public void msg(String msg) {
        System.out.println(" DirectReceiver1 : " + msg);
    }
}
