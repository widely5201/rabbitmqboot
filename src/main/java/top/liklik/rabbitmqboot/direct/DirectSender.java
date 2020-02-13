package top.liklik.rabbitmqboot.direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DirectSender {

    @Autowired
    AmqpTemplate rabbitTemplate;

    public void send1() {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//24小时制
        String context = "hello direct Message" + date;
        System.out.println("Direct Sender : " + context);
        rabbitTemplate.convertAndSend(DirectRabbitConfig.DIRECTEXCHANGE, "type1", context);
    }

    public void send2() {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//24小时制
        String context = "hello direct Message" + date;
        System.out.println("Direct Sender : " + context);
        rabbitTemplate.convertAndSend(DirectRabbitConfig.DIRECTEXCHANGE, "type2", context);
    }
}
