package top.osfun.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;
import top.osfun.bean.Color;

/**
 * Created by Jacky on 2019-05-13 19:59.
 */

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    // BeanDefinitionRegistryPostProcessor父接口方法,执行二
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor-->postProcessBeanFactory() : " + configurableListableBeanFactory.getBeanDefinitionCount());
    }

    // BeanDefinitionRegistryPostProcessor接口方法,执行一
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor-->postProcessBeanDefinitionRegistry() : " + beanDefinitionRegistry.getBeanDefinitionCount());
        // 自定义Bean
        RootBeanDefinition beanDefinition = new RootBeanDefinition(Color.class);
        beanDefinitionRegistry.registerBeanDefinition("customColor1", beanDefinition);
        AbstractBeanDefinition beanDefinition1 = BeanDefinitionBuilder.rootBeanDefinition(Color.class).getBeanDefinition();
        beanDefinitionRegistry.registerBeanDefinition("customColor2", beanDefinition1);
    }
}
