package designpattern;

import org.junit.Test;
import src.designpattern.templatepattern.HouseOne;
import src.designpattern.templatepattern.HouseTemplate;
import src.designpattern.templatepattern.HouseTwo;

/**
 * @Author zhanglianquan
 * @Description  模板模式
 * @Date 2020/1/19
 **/
public class TestTemplatePattern {

    @Test
    public  void testFactoryPattern(){
        HouseTemplate houseOne = new HouseOne("房子1");
        HouseTemplate houseTwo = new HouseTwo("房子2");
        houseOne.buildHouse();
        houseTwo.buildHouse();
    }
}
