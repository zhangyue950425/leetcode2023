package leetcodeHot100;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring_03 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length == 0 || length == 1) {
            return length;
        }
        int maxLen = 0;
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        while (right < length) {
            char ch = chars[right];
           if (set.contains(ch)) {
               set.remove(chars[left]);
               left++;
           } else {
               set.add(ch);
               right++;
           }
           maxLen = Math.max(maxLen, set.size());
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring_03 lengthOfLongestSubstring03 = new LengthOfLongestSubstring_03();
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring03.lengthOfLongestSubstring(s));
        s = "pwwkew";
        System.out.println(lengthOfLongestSubstring03.lengthOfLongestSubstring(s));
    }
}
