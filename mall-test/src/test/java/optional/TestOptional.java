package optional;

import org.junit.Test;
import src.multithread.Counter;
import src.optional.Student;

import java.util.Optional;

/**
 * @author zhanglianquan
 * 产考：https://blog.csdn.net/zjhred/article/details/84976734s
 * @date 2020/12/4
 **/
public class TestOptional {

    @Test
    public void testOptional(){
//        Student std = null;
        Student std = new Student();
        std.setName("qq");
//        Student stdNew= Optional.ofNullable(std).orElseGet(()->createStudent());
//        Student stdNew2= Optional.ofNullable(std).orElse(createStudent());
//        System.out.println(stdNew);
//        System.out.println(stdNew2);

        Student stdNew3= Optional.ofNullable(std).filter(s-> "zlq".equals(s.getName())).orElseGet(
            ()->createStudent()
        );
        System.out.println(stdNew3);
    }

    private Student createStudent(){
        Student std= new Student();
        std.setName("zlq");
        return std;
    }

}
