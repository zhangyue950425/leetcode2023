package offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class MaxQueue1 {

    private Queue<Integer> queue;
    private Deque<Integer> deque;

    public MaxQueue1() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if (deque.isEmpty()) {
            return -1;
        }
        // peekFirst
        return deque.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        Integer value = queue.peek();
        // deque.peekFirst()
        Integer dequeVal = deque.peek();
        if (Objects.equals(value, dequeVal)) {
            queue.poll();
            // deque.pollFirst();
            deque.poll();
        } else {
            queue.poll();
        }
        return value;
    }

    public static void main(String[] args) {
        MaxQueue1 maxQueue1 = new MaxQueue1();
        System.out.println(maxQueue1.max_value());
        System.out.println(maxQueue1.pop_front());
        System.out.println(maxQueue1.pop_front());
        maxQueue1.push_back(94);
        maxQueue1.push_back(16);
        maxQueue1.push_back(89);
        System.out.println(maxQueue1.pop_front());
        maxQueue1.push_back(22);
        System.out.println(maxQueue1.pop_front());
    }
}
