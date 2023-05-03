package offer;

import java.util.HashMap;
import java.util.Map;

public class IsNumber {

    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap() {{put(' ', 0); put('s', 1); put('d', 2); put('.', 4);}},
                new HashMap() {{ put('d', 2); put('.', 4); }},                           // 1.
                new HashMap() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
                new HashMap() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
                new HashMap() {{ put('d', 3); }},                                        // 4.
                new HashMap() {{ put('s', 6); put('d', 7); }},                           // 5.
                new HashMap() {{ put('d', 7); }},                                        // 6.
                new HashMap() {{ put('d', 7); put(' ', 8); }},                           // 7.
                new HashMap() {{ put(' ', 8); }}
        };
        int p = 0;
        char t;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                t = 'd';
            }
            else if (c == '+' || c == '-') {
                t = 's';
            }
            else if (c == 'e' || c == 'E') {
                t = 'e';
            }
            else if (c == '.' || c == ' ') {
                t = c;
            }
            else t = '?';
            if (!states[p].containsKey(t)) {
                return false;
            }
            p = (int) states[p].get(t);
        }
        return p == 2 || p == 3 || p == 8 || p == 7;
    }

    private String str;
    private int len;
    public boolean isNumber2(String s) {
        str = s.trim();
        len = str.length();
        if (len == 0) {
            return false;
        }
        int i = str.charAt(0) == '+' || str.charAt(0) == '-' ? 1 : 0;
        return prefixJudge(i);
    }

    private boolean prefixJudge(int i) {
        boolean res = true;
        char ch = str.charAt(i);
        if (ch == '.' && (len == i + 1 || str.charAt(i + 1) == 'e' || str.charAt(i + 1) == 'E') ||
                (ch == 'e' || ch == 'E')) {
            return false;
        }
        for (; i < len; i++) {
            char ch1 = str.charAt(i);
            if (ch1 == '.') {
                res = decimalJudge(i + 1);
                break;
            } else if (ch1 == 'e' || ch1 == 'E') {
                res = eJudge(i + 1);
                break;
            } else if (ch1 >= '0' && ch1 <= '9') {
                continue;
            } else {
                res = false;
                break;
            }
        }
        return res;
    }

    private boolean decimalJudge(int i) {
        boolean res = true;
        for (;i < len; i++) {
            char ch = str.charAt(i);
            if (ch == '.') {
                res = false;
                break;
            }
            else if (ch >= '0' && ch <= '9') {
                continue;
            }
            else if (ch == 'e' || ch == 'E') {
               res = eJudge(i + 1);
               break;
            } else {
                res = false;
                break;
            }
        }
        return res;
    }

    private boolean eJudge(int i) {
        boolean res = true;
        if (i < len && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            i++;
        }
        if (i == len) {
            return false;
        }
        for (; i < len; i++) {
            char ch = str.charAt(i);
            if (ch < '0' || ch > '9') {
                res = false;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s= "    .1  ";
        System.out.println(new IsNumber().isNumber2(s));
        s= "    +.e1  ";
        System.out.println(new IsNumber().isNumber2(s));
        s = "46.e3";
        System.out.println(new IsNumber().isNumber2(s));
    }
}
