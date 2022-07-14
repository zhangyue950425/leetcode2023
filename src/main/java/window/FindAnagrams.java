package window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (Character c : p.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            Character c = s.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                if (valid == needs.size()) {
                    res.add(left);
                }
                Character character = s.charAt(left);
                left++;
                if (needs.containsKey(character)) {
                    if (window.get(character).equals(needs.get(character))) {
                        valid--;
                    }
                    window.put(character, window.get(character) - 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // s = "cbaebabacd", p = "abc"
        String s = "cbaebabacd";
        String p = "abc";
        FindAnagrams findAnagrams = new FindAnagrams();
        System.out.println(findAnagrams.findAnagrams(s, p));
    }
}
