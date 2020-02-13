package top.liklik.rabbitmqboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.liklik.rabbitmqboot.FanoutRabbitConfig.FanoutSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitFanoutTest {
    @Autowired()
    private FanoutSender fanoutSender;
    @Test
    public void test() {
        fanoutSender.send();
    }
}
