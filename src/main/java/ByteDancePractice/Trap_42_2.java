package ByteDancePractice;

import java.util.Stack;

public class Trap_42_2 {

    /**
     * 栈
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int length = height.length;
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        int sum = 0;
        while (cur < length) {
            while (!stack.isEmpty() && height[cur] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = cur - stack.peek() - 1;
                int min = Math.min(height[cur], height[stack.peek()]);
                sum = sum + distance * (min - h);
            }
            stack.push(cur);
            cur++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Trap_42_2 trap_42_2 = new Trap_42_2();
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap_42_2.trap(height));
        height = new int[] {4,2,0,3,2,5};
        System.out.println(trap_42_2.trap(height));
    }
}
