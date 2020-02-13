package top.liklik.rabbitmqboot.FanoutRabbitConfig;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout_queue_one")
public class FanoutReceiver1 {
    @RabbitHandler
    public void msg(String msg) {
        System.out.println(" FanoutReceiver1 : " + msg);
    }
}
