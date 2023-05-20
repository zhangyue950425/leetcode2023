package Hot100;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character character : s.toCharArray()) {
            if (character == ']') {
                // 需要出栈
                // 先出的应该是字母
                StringBuilder stringBuilder = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    stringBuilder.insert(0, stack.pop());
                }
                // 后面跟的肯定是[ 这个是题目的保证
                stack.pop();
                // 再出数字
                StringBuilder num = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    num.insert(0, stack.pop());
                }
                // 拼接字符串
                int count = Integer.parseInt(num.toString());
                StringBuilder stringBuilder1 = new StringBuilder();
                while (count > 0) {
                    stringBuilder1.append(stringBuilder.toString());
                    count--;
                }
                // 再整体入栈
                for (Character character1 : stringBuilder1.toString().toCharArray()) {
                    stack.push(character1);
                }
            } else {
                // 只要不是]就可以一直入栈中
                stack.push(character);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString(s));
        s = "abc3[cd]xyz";
        System.out.println(decodeString.decodeString(s));
    }
}
