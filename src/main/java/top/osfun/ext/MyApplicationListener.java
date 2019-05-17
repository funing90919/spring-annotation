package top.osfun.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by Jacky on 2019-05-13 21:12.
 */

@Component
public class MyApplicationListener implements ApplicationListener {

    // 容器中发布事件后触发
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("收到事件" + event);
    }
}
