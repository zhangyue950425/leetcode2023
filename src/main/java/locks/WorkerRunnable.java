package locks;

import java.util.concurrent.CountDownLatch;

public class WorkerRunnable implements Runnable {

    private final CountDownLatch doneSignal;
    private final int i;

    public WorkerRunnable(CountDownLatch doneSignal, int i) {
        this.doneSignal = doneSignal;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            doWork();
            doneSignal.countDown();
        } catch (Exception e) {
        }
    }

    void doWork() {
        System.out.println(Thread.currentThread() + " doWork");
    }
}
