package top.osfun.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Created by Jacky on 2019-05-13 21:50.
 */
@Service
public class BusinessServiceImpl {

    @EventListener(classes = {ApplicationEvent.class})
    public void listner(ApplicationEvent event) {
        System.out.println("BusinessService收到事件" + event);
    }
}
