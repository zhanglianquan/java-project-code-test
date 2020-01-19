package src.designpattern.adapter;

/**
 * @Author zhanglianquan
 * @Description
 * @Date 2020/1/19
 **/
public class Usber implements Usb {

    @Override
    public void isUsb() {
        System.out.println("USB口");
    }

}
