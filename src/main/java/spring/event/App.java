package spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        /*MyPublisher myPublisher = applicationContext.getBean(MyPublisher.class);
        myPublisher.publish();*/
        applicationContext.publishEvent(new MyEvent("hello event"));
        applicationContext.publishEvent(new MySecondEvent("hello second event"));
    }
}
