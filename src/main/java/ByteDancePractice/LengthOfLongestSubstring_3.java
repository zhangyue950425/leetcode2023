package ByteDancePractice;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring_3 {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int maxLen = 0;
        if (length == 0) {
            return maxLen;
        }
        char[] chars = s.toCharArray();
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(chars[i])) {
                Integer index = map.get(chars[i]);
                start = Math.max(start, index + 1);
            }
            map.put(chars[i], i);
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring_3 lengthOfLongestSubstring_3 = new LengthOfLongestSubstring_3();
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring_3.lengthOfLongestSubstring(s));
        s = "bbbb";
        System.out.println(lengthOfLongestSubstring_3.lengthOfLongestSubstring(s));
        s = "pwwkew";
        System.out.println(lengthOfLongestSubstring_3.lengthOfLongestSubstring(s));
    }
}
