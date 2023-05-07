package Hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (map.get(s.charAt(i)) != null) {
                start = Math.max(map.get(s.charAt(i)) + 1, start);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, max = 0, length = s.length();
        while (right < length) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
            max = Math.max(max, set.size());
        }
        return max;
    }

    public static void main(String[] args) {
        // s = "abcabcbb"
        // s = "bbbbb"
        // s = "pwwkew"
        String s = "abcabcbb";
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        //System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));
        s = "bbbbb";
        //System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));
        s = "pwwkew";
        //System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));
        s = "abba";
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring2(s));
    }
}
