package top.liklik.rabbitmqboot.yanchi;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class YCSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        String context = "hello Dead rabbit " + date;
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                // 设置消息存活时间
                message.getMessageProperties().setExpiration("30000");
                message.getMessageProperties().setContentEncoding("utf-8");
                return message;
            }
        };
        rabbitTemplate.convertAndSend("ycTopicExchange", "test.dead.1", context, messagePostProcessor);
    }
}
