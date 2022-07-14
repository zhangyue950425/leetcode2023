package stack;

import java.util.Stack;

/**
 * 20
 */
public class IsValid {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if (c == ')' || c == ']' || c == '}') {
                if (!stack.isEmpty() && left(c) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private Character left(Character c) {
        if (c == ')') return '(';
        if (c == ']') return '[';
        else return '{';
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        String s = "()";
        System.out.println(s + ": " + isValid.isValid(s));
        s = "()[]{}";
        System.out.println(s + ": " + isValid.isValid(s));
        s = "(]";
        System.out.println(s + ": " + isValid.isValid(s));
        s = "([)]";
        System.out.println(s + ": " + isValid.isValid(s));
        s = "{[]}";
        System.out.println(s + ": " + isValid.isValid(s));

    }
}
