package locks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Driver2 {

    private static final int N = 8;

    public static void main(String[] args) throws InterruptedException{
        CountDownLatch doneSignal = new CountDownLatch(N);
        Executor e = Executors.newFixedThreadPool(8);
        // 创建 N 个任务，提交给线程池来执行
        for (int i = 0; i < N; i++) {
            e.execute(new WorkerRunnable(doneSignal, i));
        }
        doneSignal.await();
    }

}
