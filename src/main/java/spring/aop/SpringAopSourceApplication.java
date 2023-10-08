package spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAopSourceApplication {
    public static void main(String[] args) {
        // 启动 Spring 的 IOC 容器
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:spring_1_2_advice.xml");
        UserService userService = applicationContext.getBean(UserService.class);
        OrderService orderService = applicationContext.getBean(OrderService.class);
        userService.createUser("Tom", "Cruise", 55);
        userService.queryUser();

        orderService.createOrder("Leo", "随便买点什么");
        orderService.queryOrder("Leo");*/
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("spring.aop");
    }
}
