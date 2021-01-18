package src.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author digen
 * Created on 2019/11/18
 **/
@Configuration
@ComponentScan(value = {"src.*", "src.annotation.spel"}
//        excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
//                value = {DataSourceAutoConfiguration.class})}
                )
public class BootAutoConf {
}
