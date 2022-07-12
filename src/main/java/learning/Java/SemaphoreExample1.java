package learning.Java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore 信号量
 */
public class SemaphoreExample1 {

    private static final int threadCount = 550;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(300);
        // 一次只能允许执行的线程数量
        final Semaphore semaphore = new Semaphore(20);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            service.execute(() -> {
                try {
                    semaphore.acquire();
                    test(threadNum);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        service.shutdown();
        System.out.println("finish");
    }

    private static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("threadnum:" + threadNum);
        Thread.sleep(1000);
    }
}
