package stack;

/**
 * 921
 */
public class MinAddToMakeValid {

    public int minAddToMakeValid(String s) {
        int res = 0;
        int need = 0;
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                need++;
            }
            if (c == ')') {
                need--;
                if (need == -1) {
                    need = 0;
                    res++;
                }
            }
        }
        return need + res;
    }

    public static void main(String[] args) {
        String s = "())";
        MinAddToMakeValid minAddToMakeValid = new MinAddToMakeValid();
        System.out.println(minAddToMakeValid.minAddToMakeValid(s));
        s = "(((";
        System.out.println(minAddToMakeValid.minAddToMakeValid(s));
    }
}
