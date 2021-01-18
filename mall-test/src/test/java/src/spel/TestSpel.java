package src.spel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import src.BaseTest;

/**
 * @author zhanglianquan
 * @date 2021/1/18
 **/
public class TestSpel  extends BaseTest {
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SpringBootApplication.class)
//public class TestSpel   {
    @Test
    public void testSpel(){
        Carts carts= new Carts();
        carts.validateCarts(12L, "source1");
    }

}
