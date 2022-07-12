package window;

import java.util.HashMap;
import java.util.Map;

/**
 * 76
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();
        for (Character c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        int length = s.length();
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < length) {
            Character c = s.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (needs.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            while (valid == needs.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
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
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        // s = "ADOBECODEBANC", t = "ABC"
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow(s, t));
    }
}
