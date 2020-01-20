package datastructure;

import org.junit.Test;
import src.datastructure.CustomGenericList;

/**
 * @Author zhanglianquan
 * @Description
 * @Date 2020/1/20
 **/
public class TestGenericList {
    @Test
    public void testGenericList(){
        CustomGenericList<String> customGenericList= new CustomGenericList<>();
        customGenericList.add("爱");
        // 添加新元素列表头部，头插
        customGenericList.addHead("我");
        // 插入新元素到指定位置
        customGenericList.add(2,"中");
        customGenericList.add("国");
        customGenericList.add("!");

        //遍历输出数组
        for (String s:customGenericList) {
            System.out.println(s);
        }
        System.out.println("#######################111");
        // 从列表尾部删除元素
        customGenericList.removeFromTail();
        //遍历输出数组
        for (String s:customGenericList) {
            System.out.println(s);
        }
        // 删除指定位置上元素
        customGenericList.remove(3);
        for (String s:customGenericList) {
            System.out.println(s);
        }

        // 删除指定值的元素；
        System.out.println("#######################222");
        customGenericList.remove("中");
        for (String s:customGenericList) {
            System.out.println(s);
        }
        //判断列表中是否包含某个值；
        System.out.println("#######################333");
        System.out.println(customGenericList.contains("我"));

        // 清空列表；
        customGenericList.clear();
    }
}
