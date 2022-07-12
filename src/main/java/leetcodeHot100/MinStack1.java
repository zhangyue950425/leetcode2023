package leetcodeHot100;

import java.util.Stack;

/**
 * @author zhangyue
 * @date 2022/4/18
 * 最小栈实现2：
 * 使用Java自带的栈结构，使用两个栈来实现
 **/
public class MinStack1 {

    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    public MinStack1() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (!minStack.isEmpty()) {
            if (val <= minStack.peek()) {
                minStack.push(val);
            }
        } else {
            minStack.push(val);
        }
    }

    public void pop() {
        int val = stack.peek();
        if (val == minStack.peek()) {
            stack.pop();
            minStack.pop();
        } else {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack1 minStack = new MinStack1();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("min:" + minStack.getMin());
        minStack.pop();
        System.out.println("top:" + minStack.top());
        System.out.println("min:" + minStack.getMin());
    }
}
