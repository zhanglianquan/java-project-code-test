package test.designpattern.factorymethod;

/**
 * @Author zhanglianquan
 * @Description 具体工厂B
 * @Date 2020/1/19
 **/
public class ProductBFactory implements Factory{
    @Override
    public Product createProduct() {
        return new ProductB();
    }
}
