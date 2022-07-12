package learning.Java;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000L);
        return Thread.currentThread().getName();
    }
}
