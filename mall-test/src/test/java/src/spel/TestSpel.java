package src.spel;

import org.junit.Test;
import src.BaseTest;

/**
 * @author zhanglianquan
 * @date 2021/1/18
 **/
public class TestSpel  extends BaseTest {
//public class TestSpel   {
    @Test
    public void testSpel(){
        Carts carts= new Carts();
        carts.validateCarts(12L, "source1");
    }

}
