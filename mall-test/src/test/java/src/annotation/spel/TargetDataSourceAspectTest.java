package src.annotation.spel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import src.AppMain;
import src.annotation.tagertanotation.UserServiceImpl;

/**
 * @author zhanglianquan
 * @date 2021/1/18
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppMain.class)
public class TargetDataSourceAspectTest {
    @Autowired
    private UserServiceImpl userServiceImpl;


    @Test
    public void testSetDataSource() {
        String s = userServiceImpl.test1();
//        assertEquals("test1 method...", s);
        System.out.println(s);
    }

    @Test
    public void testSetDataSource2() {
        String s = userServiceImpl.test2();
//        assertEquals("test2 method...", s);
        System.out.println(s);
    }

    @Test
    public void testSetDataSource3() {
        String s = userServiceImpl.test3("123233");
//        assertEquals("test3 method...", s);
        System.out.println(s);
    }

    @Test
    public void testSetDataSource4() {
        String s = userServiceImpl.test4();
//        assertEquals("test4 method...", s);
        System.out.println(s);
    }


}
