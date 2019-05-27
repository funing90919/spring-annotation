package top.osfun;

import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.osfun.ext.ExtConfig;

/**
 * Created by Jacky on 2019-05-13 18:18.
 */
public class Test_Ext {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExtConfig.class);

        // 自定义事件
        context.publishEvent(new ApplicationEvent("自定义事件"){

        });

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println("============================");
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
        System.out.println("============================");

        context.close();
    }

}
