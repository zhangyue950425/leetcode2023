package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % length]) {
                stack.pop();
            }
            res[i % length] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % length]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 3};
        NextGreaterElements nextGreaterElements = new NextGreaterElements();
        System.out.println(Arrays.toString(nextGreaterElements.nextGreaterElements(nums)));
    }
}
