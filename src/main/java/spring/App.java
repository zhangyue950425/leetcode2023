package spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.aop.OrderService;
import spring.aop.UserService;

public class App {

    public static void main(String[] args) {
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
        // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring_1_2_advice.xml");
        /*ApplicationContext applicationContext = new AnnotationConfigApplicationContext("spring.aop");
        System.out.println("context 启动成功");
        UserService userService = applicationContext.getBean(UserService.class);
        OrderService orderService = applicationContext.getBean(OrderService.class);
        userService.createUser("Tom", "Cruise", 55);
        userService.queryUser();
        orderService.createOrder("Leo", "可乐");
        orderService.queryOrder("Leo");*/
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        System.out.println("context 启动成功");
        MessageService messageService = context.getBean(MessageService.class);
        System.out.println(messageService.getMessage());
    }
}
