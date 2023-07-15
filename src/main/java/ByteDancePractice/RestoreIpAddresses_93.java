package ByteDancePractice;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RestoreIpAddresses_93 {


    public List<String> restoreIpAddresses(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        List<String> result = new ArrayList<>();
        if (length < 4 || length > 12) {
            return result;
        }
        Deque<String> deque = new LinkedList<>();
        dfs(s, length, 0, 4, deque, result);
        return result;
    }

    private void dfs(String s, int length, int begin, int rest, Deque<String> deque, List<String> result) {
        // 递归终止条件
        if (begin == length) {
            if (rest == 0) {
                result.add(String.join(".", deque));
                return;
            }
        }
        for (int i = begin; i < begin + 3; i++) {
            if (length - i > 3 * rest) {
                continue;
            }
            if (i >= length) {
                break;
            }
            if (judgeIsValid(s, begin, i)) {
                deque.addLast(s.substring(begin, i + 1));
                dfs(s, length, i + 1, rest - 1, deque, result);
                deque.removeLast();
            }
        }
    }

    /**
     * 判断字符串s的索引位置在left到right之间的子串转化为整数是否在0-255之间
     * @param s
     * @param left
     * @param right
     * @return
     */
    private boolean judgeIsValid(String s, int left, int right) {
        int count = right - left + 1;
        // 前导0不是有效值
        if (count > 1 && s.charAt(left) == '0') {
            return false;
        }
        int result = 0;
        for (int i = left; i <= right; i++) {
            result = result * 10 + s.charAt(i) - '0';
        }
        return result >= 0 && result <= 255;
    }

    public static void main(String[] args) {
        RestoreIpAddresses_93 restoreIpAddresses93 = new RestoreIpAddresses_93();
        String s = "25525511135";
        System.out.println(restoreIpAddresses93.restoreIpAddresses(s));
        s = "0000";
        System.out.println(restoreIpAddresses93.restoreIpAddresses(s));
        s = "101023";
        System.out.println(restoreIpAddresses93.restoreIpAddresses(s));
    }
}
