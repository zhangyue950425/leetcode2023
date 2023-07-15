package leetcodeHot100;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring_3 {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int left = 0, right = 0, maxLen = 0;
        Set<Character> set = new HashSet<>();
        while (right < length) {
          if (!set.contains(s.charAt(right))) {
              set.add(s.charAt(right));
              right++;
          } else {
              char c = s.charAt(left);
              set.remove(c);
              left++;
          }
          maxLen = Math.max(maxLen, set.size());
        }
        return maxLen;
    }


    public static void main(String[] args) {
        LengthOfLongestSubstring_3 lengthOfLongestSubstring_3 = new LengthOfLongestSubstring_3();
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring_3.lengthOfLongestSubstring(s));
    }
}
