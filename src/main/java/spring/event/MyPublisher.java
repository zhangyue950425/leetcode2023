package spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyPublisher {

    @Autowired
    private ApplicationContext applicationContext;

    public void publish() {
        applicationContext.publishEvent(new MyEvent( "hello event"));
    }
}
