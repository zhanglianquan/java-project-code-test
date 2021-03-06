package src.designpattern;

import org.junit.Test;

/**
 * @Author zhanglianquan
 * @Description
 * @Date 2020/1/19
 **/
public class TestSingleton {
    @Test
    public void testSingletonPattern(){
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}
