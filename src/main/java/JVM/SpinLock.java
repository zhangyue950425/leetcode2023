package JVM;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinLock {
    private AtomicReference<Thread> owner = new AtomicReference<>();

    public void lock() {
        Thread thread = Thread.currentThread();
        // // 如果锁未被占用，则设置当前线程为锁的拥有者
        while (!owner.compareAndSet(null, thread)) {

        }
    }

    public void unlock() {
        Thread thread = Thread.currentThread();
        // 只有锁的拥有者才能释放锁
        owner.compareAndSet(thread, null);
    }
}
