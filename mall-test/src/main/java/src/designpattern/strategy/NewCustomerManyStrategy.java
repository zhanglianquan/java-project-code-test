package src.designpattern.strategy;

/**
 * @Author zhanglianquan
 * @Description 普通客户大批量报价
 * @Date 2020/1/19
 **/
public class NewCustomerManyStrategy implements Strategy {
    @Override
    public double getPrice(double standardPrice) {
        System.out.println("打九折");
        return standardPrice*0.9;
    }
}