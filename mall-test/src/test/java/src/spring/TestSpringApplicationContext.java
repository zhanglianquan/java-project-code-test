package src.spring;

import org.springframework.boot.SpringApplication;
import src.spring.log.SysLog;

@CustomSpringApplicationContext
public class TestSpringApplicationContext {
    @SysLog("测试日志")
    public static void main(String[] args) {
        SpringApplication.run(TestSpringApplicationContext.class, args);

    }
}

