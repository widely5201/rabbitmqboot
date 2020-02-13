package top.liklik.rabbitmqboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.liklik.rabbitmqboot.yanchi.YCSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YCRabbitTest {

    @Autowired
    private YCSender ycSender;

    @Test
    public void test() {
        ycSender.send();
    }
}
