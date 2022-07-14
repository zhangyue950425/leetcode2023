package array;

import java.util.Stack;

/**
 * 316
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        boolean[] inStack = new boolean[256];
        for (Character c : s.toCharArray()) {
            count[c]--;
            if (inStack[c]) continue;
            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek()] == 0) {
                    break;
                }
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "bcabc";
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        System.out.println(removeDuplicateLetters.removeDuplicateLetters(s));
        s = "cbacdcbc";
        System.out.println(removeDuplicateLetters.removeDuplicateLetters(s));
    }
}
