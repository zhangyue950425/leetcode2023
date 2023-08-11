package bilibili;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring_3 {


    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int maxLen = 0;
        while (left <= right && right < length) {
            char c = chars[right];
            if (!set.contains(c)) {
                set.add(c);
                right++;
            } else {
                char ch = chars[left];
                set.remove(ch);
                left++;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring_3 lengthOfLongestSubstring3 = new LengthOfLongestSubstring_3();
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring3.lengthOfLongestSubstring(s));
        s = "bbbbb";
        System.out.println(lengthOfLongestSubstring3.lengthOfLongestSubstring(s));
        s = "pwwkew";
        System.out.println(lengthOfLongestSubstring3.lengthOfLongestSubstring(s));
    }
}
