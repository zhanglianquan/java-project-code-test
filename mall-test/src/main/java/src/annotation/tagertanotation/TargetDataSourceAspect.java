package src.annotation.tagertanotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.config.BeanExpressionContext;
import org.springframework.beans.factory.config.BeanExpressionResolver;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.expression.StandardBeanExpressionResolver;
import org.springframework.stereotype.Component;

/**
 * @author zhanglianquan
 * @date 2021/1/18
 **/
@Aspect
@Component
@PropertySource("classpath:application.properties")
public class TargetDataSourceAspect {
    private static final BeanExpressionResolver resolver = new StandardBeanExpressionResolver();


    @Before("@annotation(targetDataSource)")
    public void setDataSource(TargetDataSource targetDataSource) {
        System.out.println(targetDataSource.value());

//		ExpressionParser parser = new SpelExpressionParser(config);
////		ExpressionParser parser = new SpelExpressionParser();
//		Expression exp = parser.parseExpression(targetDataSource.value());
//		Object v = exp.getValue();
//		System.out.println("====== " + v);

//		StringValueResolver svr = new StringValueResolver() {
//			@Override
//			public String resolveStringValue(String strVal) {
//				System.out.println(strVal);
//				return strVal;
//			}
//		};
//		String s = svr.resolveStringValue(targetDataSource.value());
//		System.out.println("s = " + s);
        Object s = "";
        String value = targetDataSource.value();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringBootApplication.class);
        ConfigurableBeanFactory beanFactory = context.getBeanFactory();
        String resolvedValue = beanFactory.resolveEmbeddedValue(value);
        System.out.println("resolvedValue = " + resolvedValue);
        // 字符串类型
        if (!((resolvedValue.startsWith("${") || resolvedValue.startsWith("#{")) && resolvedValue.endsWith("}"))) {
            s = resolvedValue;
        } else {
            s = resolver.evaluate(resolvedValue, new BeanExpressionContext(beanFactory, null));
        }
        System.out.println("s = " + s);

        System.out.println("使用了注解【com.ubuntuvim.sb.aop.TargetDataSource】的方法之前，先指定本方法。");
    }
}
