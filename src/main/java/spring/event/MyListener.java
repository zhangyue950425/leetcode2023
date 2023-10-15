package spring.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener {
    @EventListener
    public void onApplicationEvent(MyEvent event) {
        System.out.println(event.getMsg());
    }

    @EventListener
    public void onApplicationEvent(MySecondEvent mySecondEvent) {
        System.out.println(mySecondEvent.getMsg());
    }
}
