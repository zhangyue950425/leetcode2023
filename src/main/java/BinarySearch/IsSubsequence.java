package BinarySearch;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();

        if (tLength == 0) {
            return sLength == 0;
        }
        int i = 0, j = 0;
        while ( i < sLength && j < tLength) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i >= sLength;
    }

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence(s, t));
        s = "axc";
        t = "ahbgdc";
        System.out.println(isSubsequence.isSubsequence(s, t));
    }
}
