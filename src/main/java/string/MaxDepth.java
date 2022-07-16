package string;

/**
 * 1614
 */
public class MaxDepth {
    public int maxDepth(String s) {
        int depth = 0, size = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                ++size;
                depth = Math.max(depth, size);
            } else if (s.charAt(i) == ')'){
                --size;
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        MaxDepth maxDepth = new MaxDepth();
        System.out.println(maxDepth.maxDepth(s));
    }
}
