package src.designpattern.responsibilitychain;

/**
 * @Author zhanglianquan
 * @Description 领导抽象类， 责任链模式：当需要请求与处理对象之间的解耦时候
 * @Date 2020/1/19
 **/

public abstract class Leader {
    private Leader nextLeader;
    public Leader getNextLeader() {
        return nextLeader;
    }
    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }
    abstract public void handle(Files file);
}