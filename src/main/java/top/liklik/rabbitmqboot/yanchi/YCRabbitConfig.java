package top.liklik.rabbitmqboot.yanchi;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class YCRabbitConfig {
    @Bean
    public Queue queue1() {
        return new Queue("first");
    }

    @Bean
    public Queue queue2() {
        return new Queue("second");
    }

    /**
     *
     * topic交换器
     * @return
     */
    @Bean
    public TopicExchange ycTopicExchange(){
        return new TopicExchange("ycTopicExchange");
    }

    /**
     *
     * @return
     */
    @Bean
    Binding bindingYCExchange() {
        return BindingBuilder.bind(queue1()).to(ycTopicExchange()).with("queue.first.*");
    }

    @Bean
    Binding bindingYCExchange2() {
        return BindingBuilder.bind(queue2()).to(ycTopicExchange()).with("queue.second.#");
    }

    /**
     * dlx死信路由
     * @return
     */
    @Bean
    public TopicExchange derictExchange(){
        return new TopicExchange("dtlExchange");
    }

    /**
     * 产生死信的队列
     * @return
     */
    @Bean
    public Queue dtlQueue(){
        Map<String,Object> args = new HashMap<>();
        //指定过期消息转发的交换器名称
        args.put("x-dead-letter-exchange","dtlExchange");
        //指定跳转消息携带的roting-key
        args.put("x-dead-letter-routing-key","dead.msg.aa");
        return QueueBuilder.durable("deadQueue").withArguments(args).build();
    }

    /**
     * 绑定 消费死信的队列 和死信路由
     * @return
     */
    @Bean
    public Binding bindingDeadExchange(){
        //routing-key保持一致
        return BindingBuilder.bind(queue1()).to(derictExchange()).with("dead.msg.#");
    }

    /**
     * 绑定 产生死信的队列和任意一个路由
     * @return
     */
    @Bean
    public Binding bindingProductExchange(){
        return BindingBuilder.bind(dtlQueue()).to(ycTopicExchange()).with("test.dead.#");
    }
}
