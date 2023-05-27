package Hot100;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    // 获取最小值的栈
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            if (val <= minStack.peek()) {
                minStack.push(val);
            }
        }

    }

    public void pop() {
        Integer val = stack.pop();
        if (val.equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        /*MinStack minStack1 = new MinStack();
        minStack1.push(-2);
        minStack1.push(0);
        minStack1.push(-3);
        System.out.println(minStack1.getMin());
        minStack1.pop();
        System.out.println(minStack1.top());
        System.out.println(minStack1.getMin());*/
        MinStack minStack2 = new MinStack();
        minStack2.push(0);
        minStack2.push(1);
        minStack2.push(0);
        System.out.println(minStack2.getMin());
        minStack2.pop();
        System.out.println(minStack2.getMin());
    }
}
