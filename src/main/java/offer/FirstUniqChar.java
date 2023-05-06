package offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqChar {
    public char firstUniqChar(String s) {
        int length = s.length();
        if (length == 0) {
            return ' ';
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : chars) {
            Integer count = map.getOrDefault(c, 0);
            map.put(c, ++count);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer count = entry.getValue();
            if (count == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String s = "abaccdeff";
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        System.out.println(firstUniqChar.firstUniqChar(s));
        s = "";
        System.out.println(firstUniqChar.firstUniqChar(s));
        s = "leetcode";
        System.out.println(firstUniqChar.firstUniqChar(s));
    }
}
