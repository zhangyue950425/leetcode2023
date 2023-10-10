package designpattern.proxy;

public interface Food {

    default void setChicken(String s) {};

    default void setSpicy(String s) {};

    default void setSalt(String s) {};

    default void setNoodle(String s) {};

    default void addCondiment(String pepper) {};
}
