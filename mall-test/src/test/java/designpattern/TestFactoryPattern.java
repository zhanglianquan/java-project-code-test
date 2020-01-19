package designpattern;

import org.junit.Test;
import src.designpattern.factorymethod.Factory;
import src.designpattern.factorymethod.Product;
import src.designpattern.factorymethod.ProductAFactory;
import src.designpattern.factorymethod.ProductBFactory;

/**
 * @Author zhanglianquan
 * @Description  工厂模式
 * @Date 2020/1/19
 **/
public class TestFactoryPattern {

    @Test
    public  void testFactoryPattern(){
        Factory productAFactory = new ProductAFactory();
        Product productA = productAFactory.createProduct();
        productA.intro();

        Factory productBFactory = new ProductBFactory();
        Product productB = productBFactory.createProduct();
        productB.intro();
    }
}
