package learning.Java;

/**
 * Synchronized 代码块
 */
public class SynchronizedDemo {

    public void method() throws InterruptedException {
        /*Object o = new Object();
        o.wait();*/
        synchronized (this) {
            System.out.println("synchronized 代码块");
            //this.wait();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        synchronizedDemo.method();
    }
}
