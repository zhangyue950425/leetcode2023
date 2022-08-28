package dp;

import java.util.HashMap;
import java.util.Map;

public class IsMatch {
    Map<String, Boolean> memo;
    public boolean isMatch(String s, String p) {
        // 指针 i，j 从索引 0 开始移动
        memo = new HashMap<>();
        return dp(s, 0, p, 0);
    }

    private boolean dp(String s, int i, String p, int j) {
        int n = s.length(), m = p.length();
        if (i == n) {
            if ((m - j) % 2 == 1) {
                return false;
            }
            for (; j + 1 < m; j +=2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (j == m) {
            return i == n;
        }
        // 记录状态 (i, j)，消除重叠子问题
        String key = String.valueOf(i) + "," + String.valueOf(j);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        Boolean res;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            // 匹配
            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                // 1.1 通配符匹配 0 次或多次
                res = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                // 1.2 常规匹配 1 次
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            // 不匹配
            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                // 2.1 通配符匹配 0 次
                res = dp(s, i, p, j + 2);
            } else {
                // 2.2 无法继续匹配
                res = false;
            }
        }
        memo.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        // s = "aa", p = "a*"
        String s = "aa";
        String p = "a*";
        IsMatch isMatch = new IsMatch();
        System.out.println(isMatch.isMatch(s, p));
    }
}
