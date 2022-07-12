package leetcodeHot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null) {
            return result;
        }
        int sLength = s.length();
        int pLength = p.length();
        if (sLength < pLength) {
            return result;
        }
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        for (int i = 0; i < pLength; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pCount, sCount)) {
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
        /*List<String> pList = new ArrayList<>();
        for (Character c : p.toCharArray()) {
            pList.add("" + c);
        }
        List<String> tempList = new ArrayList<>();
        for (int i = 0; i < sLength - pLength + 1; i++) {
            tempList.clear();
            for (int j = 0; j < pLength; j++) {
                tempList.add(s.charAt(i + j) + "");
            }
            if (tempList.containsAll(pList) && pList.containsAll(tempList)) {
                result.add(i);
            }
        }*/

    }

    public static void main(String[] args) {
        // s = "cbaebabacd", p = "abc"
        // "ababababab"
        // "aab"
        String s = "ababababab";
        String p = "aab";
        FindAnagrams findAnagrams = new FindAnagrams();
        System.out.println(findAnagrams.findAnagrams(s, p));
    }
}
