package ByteDancePractice;

import java.util.Stack;

public class IsValid_20_2 {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char ch = chars[i];
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }
            else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            }
            else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValid_20_2 isValid_20_2 = new IsValid_20_2();
        String s = "()";
        System.out.println(isValid_20_2.isValid(s));
        s = "()[]{}";
        System.out.println(isValid_20_2.isValid(s));
        s = "(]";
        System.out.println(isValid_20_2.isValid(s));
    }
}
