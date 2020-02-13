package top.liklik.rabbitmqboot.FanoutRabbitConfig;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout_queue_two")
public class FanoutReceiver2 {
    @RabbitHandler
    public void msg(String msg) {
        System.out.println(" FanoutReceiver2 : " + msg);
    }
}
