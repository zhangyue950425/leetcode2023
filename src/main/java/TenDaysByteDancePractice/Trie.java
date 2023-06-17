package TenDaysByteDancePractice;

public class Trie {

    private Trie[] children;
    private boolean end;

    public Trie() {
        children = new Trie[26];
        end = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] wordChars = word.toCharArray();
        Trie root = this;
        for (int i = 0; i < wordChars.length; i++) {
            char c = wordChars[i];
            int index = c - 'a';
            Trie trie = root.children[index];
            if (trie == null) {
                root.children[index] = new Trie();
            }
            root = root.children[index];
        }
        root.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] wordChars = word.toCharArray();
        Trie root = this;
        for (int i = 0; i < wordChars.length; i++) {
            char c = wordChars[i];
            int index = c - 'a';
            if (root.children[index] == null) {
                return false;
            }
            root = root.children[index];
        }
        return root != null && root.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] prefixChars = prefix.toCharArray();
        Trie root = this;
        for (int i = 0; i < prefixChars.length; i++) {
            char c = prefixChars[i];
            int index = c - 'a';
            if (root.children[index] == null) {
                return false;
            }
            root = root.children[index];
        }
        return root  != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
