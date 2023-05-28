package Hot100;

public class Trie4 {

    class TrieNode {
        boolean isEnd;
        TrieNode[] trieNodes = new TrieNode[26];
    }

    private TrieNode root;

    public Trie4() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.trieNodes[index] == null) {
                node.trieNodes[index] = new TrieNode();
            }
            node = node.trieNodes[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.trieNodes[index] == null) {
                return false;
            }
            node = node.trieNodes[index];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.trieNodes[index] == null) {
                return false;
            }
            node = node.trieNodes[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie4 trie4 = new Trie4();
        trie4.insert("ab");
        System.out.println(trie4.search("abc"));
        System.out.println(trie4.search("ab"));
        System.out.println(trie4.startsWith("abc"));
        System.out.println(trie4.startsWith("ab"));
        trie4.insert("ab");
        System.out.println(trie4.search("abc"));
        System.out.println(trie4.startsWith("abc"));
        trie4.insert("abc");
        System.out.println(trie4.search("abc"));
        System.out.println(trie4.startsWith("abc"));
    }
}
