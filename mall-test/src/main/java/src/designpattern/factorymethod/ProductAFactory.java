package src.designpattern.factorymethod;

/**
 * @Author zhanglianquan
 * @Description 具体工厂A
 * @Date 2020/1/19
 **/
public class ProductAFactory implements Factory {
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}
