package top.liklik.rabbitmqboot.yc;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LikSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        String msg = "lik ttl";
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setContentEncoding("utf-8");
                message.getMessageProperties().setExpiration("30000");
                return message;
            }
        };
        rabbitTemplate.convertAndSend("normalExchange", "lik_ttl_key", msg, messagePostProcessor);
    }

    public void send2() {
        String str = "test";
        rabbitTemplate.convertAndSend("ttlExchange", "ttl_forward", str);
    }
}
