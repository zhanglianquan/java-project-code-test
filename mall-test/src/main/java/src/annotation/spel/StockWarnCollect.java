package src.annotation.spel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhanglianquan
 * https://blog.csdn.net/gongzi2311/article/details/94649757
 * @date 2021/1/18
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface StockWarnCollect {
    String customerId();
    String source();
    String pageType();
}
