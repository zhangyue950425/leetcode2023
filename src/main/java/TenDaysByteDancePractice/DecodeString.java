package TenDaysByteDancePractice;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        char[] sChars = s.toCharArray();
        int length = sChars.length;
        if (length == 1) {
            return s;
        }
        for (char c : sChars) {
            // 数字，入栈
            if (c >= '0' && c <= '9') {
                stack.push(c + "");
            }
            // [ 不处理 ?
            if (c == '[') {
                stack.push(c + "");
            }
            // 字符入栈
            if (c >= 'a' && c <= 'z') {
                stack.push(c + "");
            }
            // ] 出栈
            if (c == ']') {
                // 出栈第一个是字符
                String string1 = "";
                while (!stack.isEmpty() && !stack.peek().equals("[") && stack.peek().charAt(0) >= 'a' && stack.peek().charAt(0) <= 'z') {
                    string1 = stack.pop() + string1;
                }
                // [ 出栈
                stack.pop();
                // 出栈第二个是数字
                String numString = "";
                while (!stack.isEmpty() && stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9') {
                    numString = stack.pop() + numString;
                }
                int num = numString.equals("") ? 0 : Integer.parseInt(numString);
                String string2 = "";
                for (int i = 0; i < num; i++) {
                    string2 = string2 + string1;
                }
                stack.push(string2);
            }
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString(s));
        s = "3[a2[c]]";
        System.out.println(decodeString.decodeString(s));
        s = "2[abc]3[cd]ef";
        System.out.println(decodeString.decodeString(s));
        s = "abc3[cd]xyz";
        System.out.println(decodeString.decodeString(s));
        s = "100[leetcode]";
        System.out.println(decodeString.decodeString(s));
        s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        System.out.println(decodeString.decodeString(s));
    }
}
