package top.liklik.rabbitmqboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.liklik.rabbitmqboot.direct.DirectSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitDirectTest {
    @Autowired
    private DirectSender directSender;

    @Test
    public void test1() {
        directSender.send1();
    }

    @Test
    public void test2() {
        directSender.send2();
    }
}
