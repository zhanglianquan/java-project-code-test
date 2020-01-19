package src.designpattern.strategy;

/**
 * @Author zhanglianquan
 * @Description 策略模式, 适用场景：促销活动可以釆用打折、送商品、送积分等方法， 支付方式以及crm系统的报价等等
 * @Date 2020/1/19
 **/
public interface Strategy {
    public double getPrice(double  standardPrice);
}
