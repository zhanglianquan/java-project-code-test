import org.apache.coyote.Adapter;
import org.junit.Test;
import src.designpattern.Singleton;
import src.designpattern.adapter.ObjectAdapter;
import src.designpattern.adapter.Ps2;
import src.designpattern.adapter.Usber;

/**
 * @Author zhanglianquan
 * @Description 对象适配器，使用场景：想要使用一个已经存在的类，但是它却不符合现有的接口规范，导致无法直接去访问，这时创建一个适配器就能间接去访问这个类中的方法。
 * @Date 2020/1/19
 **/
public class TestObjectAdapter {
    @Test
    public void testAdapterPattern(){
        Ps2 p = new ObjectAdapter(new Usber());
        p.isPs2();
    }
}
