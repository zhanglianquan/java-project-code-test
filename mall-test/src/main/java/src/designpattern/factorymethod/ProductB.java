package src.designpattern.factorymethod;

/**
 * @Author zhanglianquan
 * @Description 具体产品B
 * @Date 2020/1/19
 **/
public class ProductB implements Product {
    @Override
    public void intro() {
        System.out.println("产品B");
    }
}