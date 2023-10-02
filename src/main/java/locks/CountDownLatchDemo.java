package locks;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 休息 5 秒后(模拟线程工作了 5 秒)，调用 countDown()
            latch.countDown();
        }, "t1");
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 休息 10 秒后(模拟线程工作了 10 秒)，调用 countDown()
            latch.countDown();
        }, "t2");
        t1.start();
        t2.start();

        Thread t3 = new Thread(() -> {
            // 阻塞，等待 state 减为 0
            try {
                latch.await();
                System.out.println("线程 t3 从 await 中返回了");
            } catch (InterruptedException e) {
                System.out.println("线程 t3 await 被中断");
                Thread.currentThread().interrupt();
            }
        }, "t3");
        Thread t4 = new Thread(() -> {
            // 阻塞，等待 state 减为 0
            try {
                latch.await();
                System.out.println("线程 t4 从 await 中返回了");
            } catch (InterruptedException e) {
                System.out.println("线程 t4 await 被中断");
                Thread.currentThread().interrupt();
            }
        }, "t4");
        t3.start();
        t4.start();
    }
}
