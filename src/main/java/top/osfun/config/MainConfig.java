package top.osfun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import top.osfun.bean.Person;

/**
 * Created by Jacky on 2019-05-11 22:01.
 */

@Configuration
@ComponentScan(value = "top.osfun.bean")
public class MainConfig {

    @Bean(name = "person001", initMethod = "init1", destroyMethod = "destroy1")
    public Person person() {
        return new Person();
    }
}
