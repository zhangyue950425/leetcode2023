package offer;

import java.util.Stack;

public class ValidateStackSequences {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek().equals(popped[i])) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println(ValidateStackSequences.validateStackSequences(pushed, popped));
        popped = new int[]{4, 3, 5, 1, 2};
        System.out.println(ValidateStackSequences.validateStackSequences(pushed, popped));
    }
}
