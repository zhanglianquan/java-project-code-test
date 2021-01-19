package src.annotation.tagertanotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.config.BeanExpressionContext;
import org.springframework.beans.factory.config.BeanExpressionResolver;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.expression.StandardBeanExpressionResolver;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import src.AppMain;

import java.lang.reflect.Method;

/**
 * @author zhanglianquan
 * @date 2021/1/18
 **/
@Aspect
@Component
@PropertySource("classpath:application.properties")
public class TargetDataSourceAspect {
    private static final BeanExpressionResolver resolver = new StandardBeanExpressionResolver();
    private final ParserContext parserContext = new TemplateParserContext();
//    //获取被拦截方法参数名列表(使用Spring支持类库)
//    private final LocalVariableTableParameterNameDiscoverer localVariableTable = new LocalVariableTableParameterNameDiscoverer();

//
//    @Before("@annotation(targetDataSource)")
//    public void setDataSource(TargetDataSource targetDataSource) {
//        System.out.println(targetDataSource.value());
//
////		ExpressionParser parser = new SpelExpressionParser(config);
//////		ExpressionParser parser = new SpelExpressionParser();
////		Expression exp = parser.parseExpression(targetDataSource.value());
////		Object v = exp.getValue();
////		System.out.println("====== " + v);
//
////		StringValueResolver svr = new StringValueResolver() {
////			@Override
////			public String resolveStringValue(String strVal) {
////				System.out.println(strVal);
////				return strVal;
////			}
////		};
////		String s = svr.resolveStringValue(targetDataSource.value());
////		System.out.println("s = " + s);
//        Object s = "";
//        String value = targetDataSource.value();
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppMain.class);
//        ConfigurableBeanFactory beanFactory = context.getBeanFactory();
//        String resolvedValue = beanFactory.resolveEmbeddedValue(value);
//        System.out.println("resolvedValue = " + resolvedValue);
//        // 字符串类型
//        if (!((resolvedValue.startsWith("${") || resolvedValue.startsWith("#{")) && resolvedValue.endsWith("}"))) {
//            s = resolvedValue;
//        } else {
//            s = resolver.evaluate(resolvedValue, new BeanExpressionContext(beanFactory, null));
//        }
//        System.out.println("s = " + s);
//
//        System.out.println("使用了注解【com.ubuntuvim.sb.aop.TargetDataSource】的方法之前，先指定本方法。");
//    }

    @Pointcut("execution(* src.annotation..*.*(..))")
    public void mobilePointCut() {
    }
    @Pointcut("@annotation(src.annotation.tagertanotation.TargetDataSource)")
    public void viewPointCut() {
    }

    @Around("mobilePointCut() && viewPointCut()")
    public void doAround(ProceedingJoinPoint point) throws Throwable{
        // 方法的参数值
        Object[] args = point.getArgs();
        //被代理的方法
        MethodSignature methodSignature = ((MethodSignature) point.getSignature());
        Method method=methodSignature.getMethod();

//        //被代理的方法上的注解
        TargetDataSource targetDataSource = method.getAnnotation(TargetDataSource.class);
        String businessIdSpel = targetDataSource.value();

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
            businessId = parser.parseExpression(businessIdSpel, parserContext).getValue(context, String.class);
        }
        System.out.println(businessId);

    }
}
