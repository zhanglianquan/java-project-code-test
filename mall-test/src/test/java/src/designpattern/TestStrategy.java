package src.designpattern;

import org.junit.Test;
import src.designpattern.strategy.Context;
import src.designpattern.strategy.OldCustomerManyStrategy;
import src.designpattern.strategy.Strategy;

/**
 * @Author zhanglianquan
 * @Description 策略模式, 适用场景：促销活动可以釆用打折、送商品、送积分等方法， 支付方式以及crm系统的报价等等
 * @Date 2020/1/19
 **/
public class TestStrategy {
    @Test
    public void testStrategyPattern(){
        Strategy s1 = new OldCustomerManyStrategy();
        Context ctx = new Context(s1);
        ctx.printPrice(998);
    }
}
