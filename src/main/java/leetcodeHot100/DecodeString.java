package leetcodeHot100;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 字符串解码:
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 */
public class DecodeString {

    public String decodeString(String s) {
        LinkedList<Integer> multiList = new LinkedList<>();
        LinkedList<String> resList = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        int multi = 0;
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                multiList.addLast(multi);
                resList.addLast(stringBuilder.toString());
                multi = 0;
                stringBuilder = new StringBuilder();
            } else if (c == ']') {
                Integer mu = multiList.removeLast();
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < mu; i++) {
                    tmp.append(stringBuilder);
                }
                stringBuilder = new StringBuilder(resList.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public String decodeString1(String s) {
        Stack<String> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || c == '[' || (c >= 'a' && c <= 'z')) {
                stack.push(c + "");
            } else {
                String result = "";
                while (!stack.peek().equals("[")) {
                    result = stack.pop() + result;
                }
                stack.pop();
                String countString = "";
                while (!stack.isEmpty() && (stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9')) {
                    countString = stack.pop() + countString;
                }
                String res = "";
                int count = Integer.parseInt(countString);
                for (int i = 0; i < count; i++) {
                    res = res + result;
                }
                stack.push(res);
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        DecodeString decodeString = new DecodeString();
        //System.out.println(decodeString.decodeString1(s));
        s = "3[a]2[bc]";
        System.out.println(decodeString.decodeString1(s));
    }
}
