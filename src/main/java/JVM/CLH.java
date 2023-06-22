package JVM;

import java.util.concurrent.atomic.AtomicReference;

/**
 * CLH锁的实现
 */
public class CLH {

    private final ThreadLocal<Node> nodeThreadLocal = ThreadLocal.withInitial(Node::new);
    private final AtomicReference<Node> tail = new AtomicReference<>(new Node());

    private static class Node {
        private volatile boolean locked;
    }

    public void lock() {
        Node node = this.nodeThreadLocal.get();
        node.locked = true;
        Node pre = this.tail.getAndSet(node);
        while (pre.locked);
    }

    public void unlock() {
        final Node node = this.nodeThreadLocal.get();
        node.locked = false;
        this.nodeThreadLocal.set(new Node());
    }
}
