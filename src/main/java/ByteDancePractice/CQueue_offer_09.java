package ByteDancePractice;

import java.util.Stack;

public class CQueue_offer_09 {

    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    public CQueue_offer_09() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        if (stack1.isEmpty()) {
            return -1;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        CQueue_offer_09 cQueueOffer09 = new CQueue_offer_09();
        System.out.println(cQueueOffer09.deleteHead());
        cQueueOffer09.appendTail(5);
        cQueueOffer09.appendTail(2);
        System.out.println(cQueueOffer09.deleteHead());
        System.out.println(cQueueOffer09.deleteHead());
    }
}
