package src.designpattern;

import org.junit.Test;
import src.designpattern.abstractfactory.AbstractFactory;
import src.designpattern.abstractfactory.AppleFactory;
import src.designpattern.abstractfactory.Fruit;

/**
 * @Author zhanglianquan
 * @Description
 * @Date 2020/1/19
 **/
public class TestAbstractFactory {

    @Test
    public  void testAbstractFactoryPattern(){
        //初始化工厂
        AbstractFactory factory = new AppleFactory();
        //得到水果
        Fruit fruit = factory.getFruit();
        fruit.draw();
    }

}
