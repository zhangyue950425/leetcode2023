package leetcodeHot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyue
 * @date 2022/4/18
 * 最小栈：
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * 实现 MinStack 类:
 * <p>
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 **/
public class MinStack {

    private final List<Integer> array;
    private int length;
    private Integer minVal;

    public MinStack() {
        array = new ArrayList<>();
        length = 0;
        minVal = 0;
    }

    public void push(int val) {
        if (this.length == 0) {
            array.add(val);
            minVal = val;
        } else {
            array.add(val);
            minVal = val;
            for (int i = 0; i < length; i++) {
                if (array.get(i) <= minVal) {
                    minVal = array.get(i);
                }
            }
        }
        this.length++;
    }

    public void pop() {
        if (length == 0) {
        } else if (length == 1) {
            array.remove(length - 1);
            this.length--;
            minVal = null;
        } else if (length == 2) {
            array.remove(length - 1);
            this.length--;
            minVal = array.get(0);
        } else {
            array.remove(length - 1);
            minVal = array.get(0);
            this.length--;
            for (int i = 1; i < length; i++) {
                if (array.get(i) <= minVal) {
                    minVal = array.get(i);
                }
            }
        }
    }

    public int top() {
        if (length == 0) {
            return 0;
        } else {
            return array.get(length - 1);
        }
    }

    public int getMin() {
        return minVal;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("min:" + minStack.getMin());
        minStack.pop();
        System.out.println("top:" + minStack.top());
        System.out.println("min:" + minStack.getMin());
    }
}
