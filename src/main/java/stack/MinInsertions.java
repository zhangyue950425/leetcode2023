package stack;

/**
 * 1541
 */
public class MinInsertions {
    public int minInsertions(String s) {
        int need = 0;
        int res = 0;
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                need = need + 2;
                if (need % 2 == 1) {
                    res++;
                    need--;
                }
            }
            if (c == ')') {
                need--;
                if (need == -1) {
                    res++;
                    need = 1;
                }
            }
        }
        return res + need;
    }


    public static void main(String[] args) {
        String s = "(()))";
        MinInsertions minInsertions = new MinInsertions();
        System.out.println(minInsertions.minInsertions(s));
        s = "())";
        System.out.println(minInsertions.minInsertions(s));
        s = "))())(";
        System.out.println(minInsertions.minInsertions(s));
        s = "((((((";
        System.out.println(minInsertions.minInsertions(s));
        s = ")))))))";
        System.out.println(minInsertions.minInsertions(s));

    }
}
