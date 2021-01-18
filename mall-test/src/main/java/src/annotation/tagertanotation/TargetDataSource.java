package src.annotation.tagertanotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhanglianquan
 * https://www.dazhuanlan.com/2019/12/24/5e021d0d18c92/
 * @date 2021/1/18
 **/
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetDataSource {
    String value() default "default";
}
