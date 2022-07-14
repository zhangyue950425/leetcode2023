package calculate;

import java.util.Stack;

/**
 * 227
 */
public class Calculate {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if ((!isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                int pre;
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        pre = stack.peek();
                        stack.pop();
                        stack.push(pre * num);
                        break;
                    case '/':
                        pre = stack.peek();
                        stack.pop();
                        stack.push(pre / num);
                        break;
                }
                sign = ch;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.peek();
            stack.pop();
        }
        return res;
    }

    private boolean isDigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // s = "3+2*2"
        String s = "3+2*2";
        Calculate calculate = new Calculate();
        System.out.println(calculate.calculate(s));
        // s = " 3/2 "
        s = " 3/2 ";
        System.out.println(calculate.calculate(s));
        // s = " 3+5 / 2 "
        s = " 3+5 / 2 ";
        System.out.println(calculate.calculate(s));
    }
}
