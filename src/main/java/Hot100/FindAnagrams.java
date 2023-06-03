package Hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        int pLength = p.length();
        int sLength = s.length();
        List<Integer> result = new ArrayList<>();
        if (sLength < pLength) {
            return result;
        }

        for (int i = 0; i <= sLength - pLength; i++) {
            String sub = s.substring(i, i + pLength);
            if (isAnagram(sub, p)) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 判断两个字符串是不是异位词，长度肯定相等
     * @param s1
     * @param s2
     * @return
     */
    private boolean isAnagram(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            int count = map1.getOrDefault(c, 0);
            map1.put(c, ++count);
        }
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : s2.toCharArray()) {
            int count = map2.getOrDefault(c, 0);
            map2.put(c, ++count);
        }
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (!map2.containsKey(key)) {
                return false;
            }
            if (!value.equals(map2.get(key))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 双指针，滑动窗口
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams2(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        List<Integer> result = new ArrayList<>();
        if (sLength < pLength) {
            return result;
        }
        // 记录字符串s中长度为pLength的子字符串中各个字符串出现的频次
        int[] schars = new int[26];
        // 记录字符串p中各个字符出现的频次
        int[] pchars = new int[26];
        for (int i = 0; i < pLength; i++) {
            pchars[p.charAt(i) - 'a']++;
        }
        for (int l = 0, r = 0; r < sLength; r++) {
            schars[s.charAt(r) - 'a']++;
            if (r - l + 1 > pLength) {
                schars[s.charAt(l) - 'a']--;
                l++;
            }
            if (checkEqual(schars, pchars)) {
                result.add(l);
            }
        }
        return result;
    }

    /**
     * 比较两个字符数组对应位置出现的字符频次是否相等，全部相等才返回true
     * @param c1
     * @param c2
     * @return
     */
    private boolean checkEqual(int[] c1, int[] c2) {
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams.findAnagrams(s, p));
        System.out.println(findAnagrams.findAnagrams2(s, p));
        s = "abab";
        p = "ab";
        System.out.println(findAnagrams.findAnagrams(s, p));
        System.out.println(findAnagrams.findAnagrams2(s, p));
    }
}
