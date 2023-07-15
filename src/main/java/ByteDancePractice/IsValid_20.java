package ByteDancePractice;

import java.util.Stack;

public class IsValid_20 {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
            } else {
                if (chars[i] == ')' && !stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
                else if (chars[i] == ']' && !stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                }
                else if (chars[i] == '}' && !stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(chars[i]);
                }
            }


        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValid_20 isValid20 = new IsValid_20();
        String s = "()[]{}";
        System.out.println(isValid20.isValid(s));
        s = "(]";
        System.out.println(isValid20.isValid(s));
        s = "()";
        System.out.println(isValid20.isValid(s));
        s = "){";
        System.out.println(isValid20.isValid(s));
    }
}
