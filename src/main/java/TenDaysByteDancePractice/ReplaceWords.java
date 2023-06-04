package TenDaysByteDancePractice;

import java.util.*;

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

    /**
     * 哈希集合
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords2(List<String> dictionary, String sentence) {
        Set<String> stringSet = new HashSet<>(dictionary);
        String[] sentences = sentence.split(" ");
        // 针对每个字符串，从字符串第0个元素开始寻找集合中是否存在，只要存在就替换，肯定是最短的前缀
        for (int i = 0; i < sentences.length; i++) {
            String s = sentences[i];
            for (int j = 0; j < s.length(); j++) {
                if (stringSet.contains(s.substring(0, j + 1))) {
                    sentences[i] = s.substring(0, j + 1);
                    break;
                }
            }
        }
        return String.join( " ", sentences);
    }

    class Trie {
        Map<Character, Trie> children;

        public Trie() {
            this.children = new HashMap<>();
        }
    }

    /**
     * 前缀树
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords3(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            Trie cur = trie;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                cur.children.putIfAbsent(c, new Trie());
                cur = cur.children.get(c);
            }
            cur.children.put('#', new Trie());
        }
        String[] sentences = sentence.split(" ");
        for (int i = 0; i < sentences.length; i++) {
            String s = findRoot(sentences[i], trie);
            sentences[i] = s;
        }
        return String.join(" ", sentences);
    }

    private String findRoot(String word, Trie trie) {
        StringBuilder stringBuilder = new StringBuilder();
        Trie cur = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children.containsKey('#')) {
                return stringBuilder.toString();
            }
            if (!cur.children.containsKey(c)) {
                return word;
            }
            stringBuilder.append(c);
            cur = cur.children.get(c);
        }
        return stringBuilder.toString();
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
        /*System.out.println(replaceWords.replaceWords(dictionary, sentence));
        System.out.println(replaceWords.replaceWords2(dictionary, sentence));*/
        System.out.println(replaceWords.replaceWords3(dictionary, sentence));
    }
}
