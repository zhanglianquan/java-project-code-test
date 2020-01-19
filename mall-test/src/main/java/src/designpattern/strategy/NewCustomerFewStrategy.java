package src.designpattern.strategy;

/**
 * @Author zhanglianquan
 * @Description 普通客户小批量报价
 * @Date 2020/1/19
 **/
public class NewCustomerFewStrategy implements Strategy {
    @Override
    public double getPrice(double standardPrice) {
        System.out.println("不打折，原价");
        return standardPrice;
    }
}