package src.spel;

import com.alibaba.fastjson.JSONArray;

import java.util.Map;
import java.util.Set;

/**
 * @author zhanglianquan
 * @date 2021/1/18
 **/
public class Carts {

    @StockWarnCollect(customerId = "#customerId", source = "#source", pageType = "2")
    public Map<String, Object> validateCarts(Long customerId, String source){
        // 省略
        return null;
    }
}
