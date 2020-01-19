package src.designpattern.strategy;

/**
 * @Author zhanglianquan
 * @Description 负责和具体的策略类交互
 * @Date 2020/1/19
 **/
public class Context {
    //当前采用的算法对象
    private Strategy strategy;

    //可以通过构造器来注入
    public Context(Strategy strategy) {
        super();
        this.strategy = strategy;
    }
    //可以通过set方法来注入
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public void printPrice(double s){
        System.out.println("您该报价："+strategy.getPrice(s));
    }
}
