package src.designpattern.factorymethod;

/**
 * @Author zhanglianquan
 * @Description 工厂方法模式  使用场景：当想把对象的创建和使用的过程分开时候， 最终目的都是为了解耦
 * @Date 2020/1/19
 **/
public interface Factory{
    Product createProduct();
}
