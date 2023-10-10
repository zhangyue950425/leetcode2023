package designpattern;

/**
 * 嵌套类
 */
public class Singleton2 {

    private Singleton2() {

    }

    private static class Holder {
        private static Singleton2 instance = new Singleton2();
    }
    public static Singleton2 getInstance() {
        return Holder.instance;
    }
}
