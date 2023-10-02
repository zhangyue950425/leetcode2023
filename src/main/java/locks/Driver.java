package locks;

import java.util.concurrent.CountDownLatch;

public class Driver {

    private static final int N = 8;

    public static void main(String[] args) throws InterruptedException{
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);
        for (int i = 0; i < N; i++) {
            new Thread(new Worker(startSignal, doneSignal)).start();
        }
        doSomeThingElse();
        startSignal.countDown();
        doSomeThingElse();
        doneSignal.await();
    }

    static void doSomeThingElse() {
        System.out.println("doSomeThingElse");
    }
}
