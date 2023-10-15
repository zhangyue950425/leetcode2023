package spring.autoconfigure;

import org.springframework.context.annotation.Conditional;

@Conditional(value = {CatCondition.class})
public class Cat {
    public Cat() {
        System.out.println("cat");
    }
}
