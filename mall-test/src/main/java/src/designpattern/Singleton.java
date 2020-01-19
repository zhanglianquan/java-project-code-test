package src.designpattern;
/**
 * @Author zhanglianquan
 * @Description  单例模式, 使用场景：当你想控制实例数目，节省系统资源的时候
 * @Date 2020/1/19
 **/
public class Singleton{

    private static class StaticInnerClass{
        private static final Singleton instance = new Singleton();
    }
    private Singleton(){}

    public static Singleton getInstance(){
        return StaticInnerClass.instance;
    }
}