package top.osfun.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * Created by Jacky on 2019-05-11 23:38.
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private Environment environment;
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor====" + applicationContext);
        System.out.println("BeanPostProcessor====" + environment.getProperty("os.name"));
        System.out.println("BeanPostProcessor====" + resourceLoader.getClassLoader().toString());
        System.out.println("BeanPostProcessor====" + applicationEventPublisher);
        System.out.println("BeanPostProcessor postProcessBeforeInitialization()" + beanName + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor postProcessAfterInitialization()" + beanName + bean);
        return bean;
    }
}
