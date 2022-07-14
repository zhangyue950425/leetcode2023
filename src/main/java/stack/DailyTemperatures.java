package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(temperatures)));
    }
}
