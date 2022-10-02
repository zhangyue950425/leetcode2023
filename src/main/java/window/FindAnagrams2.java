package window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams2 {
    public List<Integer> findAnagrams(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        List<Integer> result = new ArrayList<>();
        if (pLength > sLength) {
            return result;
        }
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLength; i++) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sCount, pCount)) {
            result.add(0);
        }
        for (int i = 0; i < sLength - pLength; i++) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLength) - 'a'];
            if (Arrays.equals(sCount, pCount)) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // s = "cbaebabacd", p = "abc"
        String s = "cbaebabacd", p = "abc";
        FindAnagrams2 findAnagrams2 = new FindAnagrams2();
        System.out.println(findAnagrams2.findAnagrams(s, p));
    }
}
