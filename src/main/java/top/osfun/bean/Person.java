package top.osfun.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 *
 Person 构造器
 BeanPostProcessor postProcessBeforeInitialization()person001Person{name='null', age=null}
 Person @PostConstruct333
 InitializingBean afterPropertiesSet()222
 Person 自定义初始化方法111
 BeanPostProcessor postProcessAfterInitialization()person001Person{name='funing', age=20}
 容器创建完成
 Person @PreDestroy333
 DisposableBean destroy()222
 Person 自定义销毁方法111
 *
 *  Created by Jacky on 2019-05-11 21:53
 */
public class Person implements InitializingBean, DisposableBean{

    private String name;
    private Integer age;

    public Person() {
        System.out.println("Person 构造器");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public void init1() {
        this.name = "funing";
        this.age = 20;
        System.out.println("Person 自定义初始化方法111");
    }
    public void destroy1() {
        System.out.println("Person 自定义销毁方法111");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean afterPropertiesSet()222");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy()222");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Person @PostConstruct333");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Person @PreDestroy333");
    }
}
