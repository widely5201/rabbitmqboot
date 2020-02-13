package top.liklik.rabbitmqboot.yanchi;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "first")
public class YCReceiver {
    @RabbitHandler
    public void rece(String msg) {
        System.out.println("YCReceiver : " + msg);
    }
}
