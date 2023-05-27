package Hot100;

public class Trie2 {

    private Trie2[] children;
    private boolean isEnd;

    public Trie2() {
        children = new Trie2[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie2 node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie2();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie2 trie2 = searchPrefix(word);
        return trie2 != null && trie2.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie2 searchPrefix(String prefix) {
        Trie2 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    public static void main(String[] args) {
        Trie2 trie2 = new Trie2();
        trie2.insert("ab");
        System.out.println(trie2.search("abc"));
        System.out.println(trie2.search("ab"));
        System.out.println(trie2.startsWith("abc"));
        System.out.println(trie2.startsWith("ab"));
        trie2.insert("ab");
        System.out.println(trie2.search("abc"));
        System.out.println(trie2.startsWith("abc"));
        trie2.insert("abc");
        System.out.println(trie2.search("abc"));
        System.out.println(trie2.startsWith("abc"));
    }
}
