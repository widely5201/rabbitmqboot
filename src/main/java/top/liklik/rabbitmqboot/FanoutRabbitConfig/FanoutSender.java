package top.liklik.rabbitmqboot.FanoutRabbitConfig;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component(value = "fanoutSender")
public class FanoutSender {

    @Autowired
    AmqpTemplate rabbitTemplate;

    public void send() {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//24小时制
        String context = "hello fanout Message" + date;
        System.out.println("Fanout Sender : " + context);
        rabbitTemplate.convertAndSend("mybootFanoutExchange", "", context);
    }
}
