package src;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import src.config.BootAutoConf;

/**
 * @author zhanglianquan
 * @date 2021/1/18
 **/
//@Slf4j
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BootAutoConf.class})
//@ActiveProfiles("dev")
public class BaseTest {
    @Test
    public void testInit() {
    }
}
