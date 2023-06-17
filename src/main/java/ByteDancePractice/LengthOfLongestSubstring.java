package ByteDancePractice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {


    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int length = s.length();
        /*if (length == 0) {
            return maxLen;
        }*/
        int start = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
                int len = i - start + 1;
                maxLen = Math.max(maxLen, len);
            } else {
                int count = map.get(c);
                start = count + 1;
                int len = i - start + 1;
                maxLen = Math.max(maxLen, len);
                map.put(c, i);
            }
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, maxLen = 0;
        int length = s.length();
        while (right < length) {
            char c = s.charAt(right);
            if (!set.contains(c)) {
                set.add(c);
                right++;
            } else {
                char c1 = s.charAt(left);
                set.remove(c1);
                left++;
            }
            maxLen = Math.max(maxLen, set.size());
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        String s = "abcabcbb";
        //System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring2(s));
        s = "pwwkew";
        //System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring2(s));
        s = " ";
        //System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring2(s));
    }
}
