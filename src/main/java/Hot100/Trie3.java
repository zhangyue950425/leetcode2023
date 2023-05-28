package Hot100;

/**
 * 二维数组实现前缀树
 */
public class Trie3 {

    private int[][] tries;
    private int[] count;
    private int index;

    private int N = 100009; // 十万级别

    public Trie3() {
        tries = new int[N][26];
        count = new int[N];
        index = 0;
    }

    public void insert(String word) {
        int row = 0;
        for (int i = 0; i < word.length(); i++) {
            int col = word.charAt(i) - 'a';
            if (tries[row][col] == 0) {
                tries[row][col] = ++index;
            }
            row = tries[row][col];
        }
        count[row]++;
    }

    public boolean search(String word) {
        int row = 0;
        for (int i = 0; i < word.length(); i++) {
            int col = word.charAt(i) - 'a';
            if (tries[row][col] == 0) {
                return false;
            }
            row = tries[row][col];
        }
        return count[row] != 0;
    }

    public boolean startsWith(String prefix) {
        int row = 0;
        for (int i = 0; i < prefix.length(); i++) {
            int col = prefix.charAt(i) - 'a';
            if (tries[row][col] == 0) {
                return false;
            }
            row = tries[row][col];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie3 trie3 = new Trie3();
        trie3.insert("ab");
        System.out.println(trie3.search("abc"));
        System.out.println(trie3.search("ab"));
        System.out.println(trie3.startsWith("abc"));
        System.out.println(trie3.startsWith("ab"));
        trie3.insert("ab");
        System.out.println(trie3.search("abc"));
        System.out.println(trie3.startsWith("abc"));
        trie3.insert("abc");
        System.out.println(trie3.search("abc"));
        System.out.println(trie3.startsWith("abc"));
    }
}
