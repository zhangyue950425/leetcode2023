package TenDaysByteDancePractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWords {

    /**
     * 暴力解法
     * @param dictionary
     * @param sentence
     * @return
     */
    Map<String, String> map = new HashMap<>();
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] sentences = sentence.split(" ");
        for (int i = 0; i < sentences.length; i++) {
            String s = sentences[i];
            int num = 0;
            for (String prefix : dictionary) {
                int count = startWith(prefix, s);
                if (count != 0) {
                    if (map.containsKey(s)) {
                        String s1 = map.get(s);
                        // 当前前缀更短
                        if (s1.length() > prefix.length()) {
                            map.put(s, prefix);
                        }
                    } else {
                        map.put(s, prefix);
                    }

                } else {
                    num++;
                }
            }
            // 前缀一个都没有匹配上
            if (num == dictionary.size()) {
                stringBuilder.append(s);
                if (i != sentences.length - 1) {
                    stringBuilder.append(" ");
                }
            } else {
                stringBuilder.append(map.get(s));
                if (i != sentences.length - 1) {
                    stringBuilder.append(" ");
                }
            }
        }
        return stringBuilder.toString();
    }

    private int startWith(String prefix, String s) {
        int prefixLength = prefix.length();
        int sLength = s.length();
        if (prefixLength> sLength) {
            return 0;
        }
        char[] prefixChars = prefix.toCharArray();
        char[] sChars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < sLength && i < prefixLength; i++) {
            if (prefixChars[i] != sChars[i]) {
                return 0;
            } else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        String sentence = "the cattle was rattled by the battery";
        ReplaceWords replaceWords = new ReplaceWords();
        //System.out.println(replaceWords.replaceWords(dictionary, sentence));
        //sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba abab";
        dictionary.clear();
        // "a", "aa", "aaa", "aaaa"
        dictionary.add("a");
        dictionary.add("aa");
        dictionary.add("aaa");
        dictionary.add("aaaa");
        //System.out.println(replaceWords.replaceWords(dictionary, sentence));
        // "catt","cat","bat","rat"
        dictionary.clear();
        dictionary.add("catt");
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        System.out.println(replaceWords.replaceWords(dictionary, sentence));
    }
}
