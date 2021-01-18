package src.designpattern;

import org.junit.Test;
import src.designpattern.responsibilitychain.*;

/**
 * @Author zhanglianquan
 * @Description 责任链模式：当需要请求与处理对象之间的解耦时候
 * @Date 2020/1/19
 **/
public class TestResponsibilityChain {
    @Test
    public void testChainPattern(){
        //定义职责链
        Leader topManager = new TopManager();
        Leader assistantManager = new AssistantManager();
        Leader departmentManager = new DepartmentManager();
        departmentManager.setNextLeader(assistantManager);
        assistantManager.setNextLeader(topManager);
        //定义两份文件
        Files f1 = new Files();
        f1.setFileName("正确对待旱鸭子");
        f1.setLevel(1);
        Files f2 = new Files();
        f2.setFileName("年会在那里举行");
        f2.setLevel(0);
        //提交文件
        departmentManager.handle(f1);
        departmentManager.handle(f2);
    }

}
