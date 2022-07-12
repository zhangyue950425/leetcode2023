package learning.Java;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.Executors;

public class ThreadLocalExample implements Runnable {
    private static final ThreadLocal<SimpleDateFormat> th = ThreadLocal
            .withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample threadLocalExample = new ThreadLocalExample();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(threadLocalExample, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
        //Executors.newFixedThreadPool();
        Executors.newCachedThreadPool();
        //new ThreadPoolExecutor();
        //ThreadPoolExecutor.CallerRunsPolicy;
    }

    @Override
    public void run() {
        System.out.println("Thread Name= " + Thread.currentThread().getName()
                + " default Formatter = " + th.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        th.set(new SimpleDateFormat());
        System.out.println("Thread Name= " + Thread.currentThread().getName()
                + " formatter = " + th.get().toPattern());
    }
}
