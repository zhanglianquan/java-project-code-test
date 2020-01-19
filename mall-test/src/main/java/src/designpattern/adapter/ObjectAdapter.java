package src.designpattern.adapter;

/**
 * @Author zhanglianquan
 * @Description 对象适配器，使用场景：想要使用一个已经存在的类，但是它却不符合现有的接口规范，导致无法直接去访问，这时创建一个适配器就能间接去访问这个类中的方法。
 * @Date 2020/1/19
 **/

public class ObjectAdapter implements Ps2 {

    private Usb usb;
    public ObjectAdapter(Usb usb){
        this.usb = usb;
    }
    @Override
    public void isPs2() {
        usb.isUsb();
    }
}
