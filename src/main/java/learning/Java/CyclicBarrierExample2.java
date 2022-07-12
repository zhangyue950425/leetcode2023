package learning.Java;

import java.util.concurrent.*;

public class CyclicBarrierExample2 {

    private static final int threadCount = 550;
    private static final CyclicBarrier cy = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executorService.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException, BrokenBarrierException {
        System.out.println("threadNum:" + threadNum + "is ready");
        try {
            cy.await(60, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("-----CyclicBarrierException------");
        }
        System.out.println("threadNum:" + threadNum + "is finish");
    }

}
