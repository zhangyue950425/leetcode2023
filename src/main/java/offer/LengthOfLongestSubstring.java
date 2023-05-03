package offer;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int result = 0, val = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1);
            dic.put(s.charAt(j), j);
            val = val < j - i ? val + 1 : j - i;
            result = Math.max(result, val);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(LengthOfLongestSubstring.lengthOfLongestSubstring(s));
    }
}
