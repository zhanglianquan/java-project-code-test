package src.designpattern.abstractfactory;

/**
 * @Author zhanglianquan
 * @Description
 * @Date 2020/1/19
 **/
public class BananaFactory extends AbstractFactory{

    @Override
    public Fruit getFruit() {
        return new Banana();
    }
}