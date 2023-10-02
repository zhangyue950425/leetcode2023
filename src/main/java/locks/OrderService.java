package locks;

import java.util.concurrent.locks.ReentrantLock;

public class OrderService {

    private static ReentrantLock reentrantLock = new ReentrantLock(true);

    public void createOrder() {
        reentrantLock.lock();
        try {

        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        orderService.createOrder();
    }
}
