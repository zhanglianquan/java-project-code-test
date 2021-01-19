package src.annotation.tagertanotation;

import java.lang.annotation.*;

/**
 * @author zhanglianquan
 * https://www.dazhuanlan.com/2019/12/24/5e021d0d18c92/
 * @date 2021/1/18
 **/
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
//@Inherited
@Documented
public @interface TargetDataSource {
    String value() default "default";
}
