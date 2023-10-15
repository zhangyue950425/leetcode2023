package spring.autoconfigure;

import org.springframework.context.annotation.Conditional;

@Conditional({DogCondition.class})
public class Dog {
    public Dog() {
        System.out.println("dog");
    }
}
