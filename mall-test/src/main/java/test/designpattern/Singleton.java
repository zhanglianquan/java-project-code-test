package test.designpattern;
/**
 * @Author zhanglianquan
 * @Description  单例模式
 * @Date 2020/1/19
 **/
public class Singleton{

    private static class StaticInnerClass{
        private static final Singleton instance = new Singleton();
    }
    private Singleton(){}

    private static Singleton getInstance(){
        return StaticInnerClass.instance;
    }
}