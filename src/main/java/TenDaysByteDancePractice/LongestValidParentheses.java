package TenDaysByteDancePractice;

import javafx.util.Pair;

import java.util.Stack;

/**
 * 32. 最长有效括号:
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int length = s.length();
        char[] sChars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        if (length == 0) {
            return count;
        }
        stack.push(sChars[0]);
        int index = 1;
        while (index < length) {
            char c = sChars[index];
            if (c == '(') {
                stack.push(c);
                index++;
            } else {
                // c == ')'
                if (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                        count = count + 2;
                        index++;
                    } else {
                        stack.pop();
                        index++;
                    }
                } else {
                    index++;
                }
            }
        }
        return count;
    }

    public int longestValidParentheses2(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        char[] sChars = s.toCharArray();
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < length; i++) {
            if (sChars[i] == '(') {
                stack.push(i);
            } else {
                // )括号
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    count = Math.max(count, i - stack.peek());
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // 输入：s = "(()"
        // 输出：2
        // 解释：最长有效括号子串是 "()"
        // 输入：s = ")()())"
        // 输出：4
        // 解释：最长有效括号子串是 "()()"
        // 输入：s = ""
        // 输出：0
        String s = "(()";
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        //System.out.println(longestValidParentheses.longestValidParentheses(s));
        System.out.println(longestValidParentheses.longestValidParentheses2(s));
        s = ")()())";
        //System.out.println(longestValidParentheses.longestValidParentheses(s));
        System.out.println(longestValidParentheses.longestValidParentheses2(s));
        s = "";
        //System.out.println(longestValidParentheses.longestValidParentheses(s));
        System.out.println(longestValidParentheses.longestValidParentheses2(s));
        s = "()()";
        //System.out.println(longestValidParentheses.longestValidParentheses(s));
        System.out.println(longestValidParentheses.longestValidParentheses2(s));
        s = "())";
        //System.out.println(longestValidParentheses.longestValidParentheses(s));
        System.out.println(longestValidParentheses.longestValidParentheses2(s));
    }
}
