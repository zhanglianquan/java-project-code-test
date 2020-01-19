package src.designpattern.abstractfactory;

/**
 * @Author zhanglianquan
 * @Description 抽象工厂模式：当需要创建的对象是一系列相互关联或相互依赖的产品族时
 * @Date 2020/1/19
 **/
public abstract class AbstractFactory {
    public abstract  Fruit getFruit();
}
