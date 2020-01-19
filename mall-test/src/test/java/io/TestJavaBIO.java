package io;

import org.junit.Test;
import src.io.bio.JavaBIO;
import src.io.nio.JavaNIO;

/**
 * @Author zhanglianquan
 * @Description
 * @Date 2020/1/19
 **/
public class TestJavaBIO {
    @Test
    public void testNIO(){
        JavaBIO.readBIO();
        JavaBIO.writeBIO();
    }

}
