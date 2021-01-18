package src.annotation.tagertanotation;

import org.springframework.stereotype.Service;

/**
 * @author zhanglianquan
 * @date 2021/1/18
 **/
@Service
public class UserServiceImpl {
    @TargetDataSource("test1")
    public String test1() {
        return "test1 method...";
    }

    @TargetDataSource("${ds}")
    public String test2() {
        return "test2 method...";
    }

    @TargetDataSource("#{EnvUtil.getValue('1')}")
    public String test3() {
        return "test3 method...";
    }

    @TargetDataSource("#{EnvUtil.getValue('2')}")
    public String test4() {
        return "test4 method...";
    }
}
