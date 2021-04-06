package src.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author zhanglianquan
 * @date 2021/4/6
 **/
public class JOLExample1 {
    static  B b = new B();
    public static void main(String[] args) {
        //jvm的信息
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseInstance(b).toPrintable());
    }

    public static class B {

    }
}
