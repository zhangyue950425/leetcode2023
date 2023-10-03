package spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1.首先会获取 AService 对应的 Bean 对象。
 * 2.先是调用 doGetBean() 中的第一个 getSingleton(beanName) 判断是否有该 Bean 的实例，有就直接返回了。（显然这里没有）
 * 3.然后调用 doGetBean() 中的第二个 getSingleton() 方法来执行 doCreateBean() 方法。
 * 4.先进行实例化操作（也就是利用构造函数实例化），此时实例化后生成的是原始对象。
 * 5.将原始对象通过 lambda表达式 进行封装成 ObjectFactory 对象，通过 addSingletonFactory 加入三级缓存中。
 * 6.然后再进行属性注入，此时发现需要注入 BService 的 Bean，会通过 doGetBean() 去获取 BService 对应的 Bean。
 * 7.同样调用 doGetBean() 中的第一个 getSingleton(beanName) 判断是否有该 Bean 的实例，显然这里也是不会有 BService 的 Bean 的。
 * 8.然后只能调用 doGetBean() 中的第二个 getSingleton() 方法来执行 doCreateBean() 方法来创建一个 BService 的 Bean。
 * 9.同样地先进行实例化操作，生成原始对象后封装成 ObjectFactory 对象放入三级缓存中。
 * 10.然后进行属性注入，此时发现需要注入 AService 的 Bean，此时调用调用 doGetBean() 中的第一个 getSingleton(beanName) 查找是否有 AService 的 Bean。
 * 此时会触发三级缓存，也就是调用 singletonFactories.get(beanName)。
 * 11.因为三级缓存中有 AService 的原始对象封装的 ObjectFactory 对象，所以可以获取到的代理对象或原始对象，
 * 并且上移到二级缓存中，提前暴露给 BService 调用。
 * 12.所以 BService 可以完成属性注入，然后进行初始化后，将 Bean 放入一级缓存，这样 AService 也可以完成创建。
 */
public class Application {

    public static void main(String[] args) {
        /*ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("application-context.xml");
        AService aService = (AService) applicationContext.getBean("aService");
        System.out.println("执行成功，获取AService对象为：" + aService);*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("spring.ioc");
        A a = applicationContext.getBean(A.class);
        B b = applicationContext.getBean(B.class);
        System.out.println(a + "," + b);
    }
}

