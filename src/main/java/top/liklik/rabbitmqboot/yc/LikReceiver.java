package top.liklik.rabbitmqboot.yc;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class LikReceiver {
    @RabbitHandler
    public void msg(String msg) {
        System.out.println("LikReceiver : " +msg);
    }
}
