package src.multithread;

import org.junit.Test;

/**
 * @Author zhanglianquan
 * @Description
 * @Date 2020/1/20
 **/
public class TestCounter {
    @Test
    public void testCounter(){
        try {
            Counter.safeCount();
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
