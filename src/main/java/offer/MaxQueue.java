package offer;

import java.util.LinkedList;

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
public class MaxQueue {

    private LinkedList<Integer> linkedList;
    private int max;
    private int front;

    public MaxQueue() {
        linkedList = new LinkedList<>();
        max = -1;
        front = -1;
    }

    public int max_value() {
        if (linkedList.isEmpty()) {
            return max;
        }
         return linkedList.getLast();
    }

    public void push_back(int value) {
        if (linkedList.isEmpty()) {
            linkedList.addFirst(value);
            front = value;
            max = value;
            return;
        }
        Integer maxVal = linkedList.getLast();
        if (value > max) {
            linkedList.addLast(value);
            max = value;
        } else {
            linkedList.addLast(value);
        }
    }

    public int pop_front() {
        if (linkedList.isEmpty()) {
            return front;
        }
        linkedList.remove((Object) front);
        int newFront = front;
        front = linkedList.getFirst();
        return newFront;
    }

    public static void main(String[] args) {
        /*MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        maxQueue = new MaxQueue();
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());*/
        System.out.println("-------------------------");
        MaxQueue maxQueue = new MaxQueue();
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.pop_front());
        maxQueue.push_back(94);
        maxQueue.push_back(16);
        maxQueue.push_back(89);
        System.out.println(maxQueue.pop_front());
        maxQueue.push_back(22);
        System.out.println(maxQueue.pop_front());
    }
}
