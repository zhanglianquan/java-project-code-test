package src.annotation.tagertanotation;

import org.springframework.stereotype.Component;

/**
 * @author zhanglianquan
 * @date 2021/1/18
 **/
@Component("EnvUtil")
public class EnvUtil {
    public static String getValue(String key) {
        if ("1".equals(key)){

            return "key1";
        }

        if ("2".equals(key)){

            return "ds";
        }

        if ("3".equals(key)){
            return "key"+key;
        }


        return "";
    }
}
