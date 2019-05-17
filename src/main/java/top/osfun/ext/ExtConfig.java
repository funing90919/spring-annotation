package top.osfun.ext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import top.osfun.bean.Color;

/**
 * Spring扩展原理
 * 1.BeanPostProcessor：Bean后置处理器，Bean创建对象初始化前后拦截工作
 *
 * 2.BeanFactoryPostProcessor：BeanFactory后置处理器，BeanFactory标准初始化之后调用，定制和修改BeanFactory内容
 *      所有Bean定义已经保存加载到BeanFactory，但是Bean实例未创建。
 *      1.创建IOC容器对象;
 *      2.invokeBeanFactoryPostProcessors(beanFactory);执行BeanFactoryPostProcessor
 *          1).在BeanFactory中寻找BeanFactoryPostProcessor类型的组件，并执行相应方法；
 *          2).在初始化创建其他组件组件前执行；
 *
 * 3.BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
 *      postProcessBeanDefinitionRegistry(BeanDefinitionRegistry var1)；所有Bean定义将要加载到BeanFactory前执行
 *
 *      总结：BeanDefinitionRegistryPostProcessor优先于BeanFactoryPostProcessor执行，可向容器中添加额外组件；
 * 4.ApplicationListener：监听容器中发布的事件，事件驱动模型开发；
 *      interface ApplicationListener<E extends ApplicationEvent>：监听ApplicationEvent及其子类；
 *      自定义事件步骤：
 *          1.自定义监听器监听某个事件(ApplicationEvent及其子类)或者@EventListner；
 *          2.监听器加入容器；
 *          3.Spring自动监听；
 *              ContextRefreshedEvent：容器刷新完成(所有Bean创建完成)会发布；
 *              ContextClosedEvent：关闭容器发布；
 *
 *  【事件发布流程】
 *      例如：ContextRefreshedEvent
 *      1.publishEvent(new ContextRefreshedEvent(this));容器刷新后发布事件；
 *      2.getApplicationEventMulticaster().multicastEvent(applicationEvent, eventType);获取事件派发器并派发事件；
 *      3.for (final ApplicationListener<?> listener : getApplicationListeners(event, type))；获取所有ApplicationListener，
 *          回调listener.onApplicationEvent(event);
 *
 *
 *
 * Created by Jacky on 2019-05-13 18:08.
 */
@Configuration
@ComponentScan({"top.osfun.ext"})
public class ExtConfig {

    @Bean
    public Color color() {
        return new Color();
    }

}
