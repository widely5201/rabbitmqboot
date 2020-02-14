package top.liklik.rabbitmqboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.liklik.rabbitmqboot.yc.LikSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LikTest {

    @Autowired
    private LikSender likSender;

    @Test
    public void test() {
        likSender.send();
    }
}
