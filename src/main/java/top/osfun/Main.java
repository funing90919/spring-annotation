package top.osfun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.osfun.bean.Person;
import top.osfun.config.MainConfig;

/**
 * Created by Jacky on 2019-05-11 21:57
 */
public class Main {

    public static void main(String[] args) {
        // xml();
        annotation();
    }

    private static void xml() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }

    private static void annotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println("容器创建完成");
        //applicationContext.getBean(Person.class);
        /*String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }*/

        // 关闭容器
        applicationContext.close();
    }

    /*class Singleton {
        private static final AtomicReference<Singleton> INSTANCE = new AtomicReference<>();
        private Singleton(){}
        public static Singleton getInstance() {
            while (true) {
                Singleton singleton = INSTANCE.get();
                if (singleton != null) {
                    return singleton;
                }

                singleton = new Singleton();
                if (INSTANCE.compareAndSet(null, singleton)) {
                    return singleton;
                }
            }
        }
    }*/
}
