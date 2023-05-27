package Hot100;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private Map<String, String> words;

    public Trie() {
        words = new HashMap<>();
    }

    public void insert(String word) {
        words.put(word, word);
    }

    public boolean search(String word) {
        return words.containsKey(word);
    }

    public boolean startsWith(String prefix) {
        for (Map.Entry<String, String> entry : words.entrySet()) {
            String word = entry.getKey();
            char[] prefixChars = prefix.toCharArray();
            char[] wordChars = word.toCharArray();
            int count = 0;
            for (int i = 0; i < prefixChars.length && i < wordChars.length; i++) {
                if (prefixChars[i] == wordChars[i]) {
                    count++;
                }
            }
            if (count == prefixChars.length) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
        trie = new Trie();
        trie.insert("hello");
        System.out.println(trie.search("hell"));
        System.out.println(trie.search("helloa"));
        System.out.println(trie.search("hello"));
        System.out.println(trie.startsWith("hell"));
        System.out.println(trie.startsWith("helloa"));
        System.out.println(trie.startsWith("hello"));
        // "Trie","insert","search","search","startsWith","startsWith","insert",
        // "search","startsWith","insert","search","startsWith"
        // [[],["ab"],["abc"],["ab"],["abc"],["ab"],["ab"],["abc"],["abc"],["abc"],["abc"],["abc"]]
        trie = new Trie();
        trie.insert("ab");
        System.out.println(trie.search("abc"));
        System.out.println(trie.search("ab"));
        System.out.println(trie.startsWith("abc"));
        System.out.println(trie.startsWith("ab"));
        trie.insert("ab");
        System.out.println(trie.search("abc"));
        System.out.println(trie.startsWith("abc"));
        trie.insert("abc");
        System.out.println(trie.search("abc"));
        System.out.println(trie.startsWith("abc"));
    }
}
