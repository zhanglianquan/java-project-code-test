package multithread;

import org.junit.Test;
import src.multithread.Counter;

import java.util.ArrayList;
import java.util.List;

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
