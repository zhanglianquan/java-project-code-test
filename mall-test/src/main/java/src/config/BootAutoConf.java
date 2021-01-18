package src.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author digen
 * Created on 2019/11/18
 **/
@Configuration
@ComponentScan(value = {"src.*", "src.spel"}
//        excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
//                value = {DataSourceAutoConfiguration.class})}
                )
public class BootAutoConf {
}
