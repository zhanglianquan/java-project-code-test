package src.spel;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author zhanglianquan
 * @date 2021/1/18
 **/
@Aspect
@Component
public class StockWarnCollectAop {
    @After("@annotation(src.spel.StockWarnCollect) &&@annotation(operationLog)")
    public void interceptOperation(JoinPoint point, StockWarnCollect operationLog) {
        String businessIdSpel = operationLog.pageType();
        // 方法的参数值
        Object[] args = point.getArgs();
        //被代理的方法
        Method method = ((MethodSignature) point.getSignature()).getMethod();
        //获取被拦截方法参数名列表(使用Spring支持类库)
        LocalVariableTableParameterNameDiscoverer localVariableTable = new LocalVariableTableParameterNameDiscoverer();
        // 方法的参数名
        String[] paraNameArr = localVariableTable.getParameterNames(method);
        //使用SPEL进行key的解析
        ExpressionParser parser = new SpelExpressionParser();
        //SPEL上下文
        StandardEvaluationContext context = new StandardEvaluationContext();
        //将方法的参数名和参数值一一对应的放入SPEL上下文中
        for(int i=0;i<paraNameArr.length;i++) {
            context.setVariable(paraNameArr[i], args[i]);
        }
        String businessId = null;
        // 使用变量方式传入业务动态数据
        if(businessIdSpel.matches("^#.*.$")) {
            // 解析SpEL表达式获取结果
            businessId = parser.parseExpression(businessIdSpel).getValue(context, String.class);
        }
        System.out.println(businessId);
    }
}
