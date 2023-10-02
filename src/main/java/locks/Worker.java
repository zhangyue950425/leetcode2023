package locks;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable{

    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            startSignal.await();
            doWork();
            doneSignal.countDown();
        } catch (InterruptedException e) {

        }
    }

    void doWork() {
        System.out.println(Thread.currentThread() + " doWork");
    }
}
