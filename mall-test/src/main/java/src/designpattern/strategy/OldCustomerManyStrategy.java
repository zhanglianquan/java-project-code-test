package src.designpattern.strategy;

/**
 * @Author zhanglianquan
 * @Description 老客户大批量报价
 * @Date 2020/1/19
 **/
public class OldCustomerManyStrategy implements Strategy {
    @Override
    public double getPrice(double standardPrice) {
        System.out.println("打八折");
        return standardPrice*0.8;
    }
}
