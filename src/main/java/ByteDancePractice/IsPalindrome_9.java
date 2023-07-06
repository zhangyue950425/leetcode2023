package ByteDancePractice;

public class IsPalindrome_9 {

    /**
     * 暴力法
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int length = s.length();
        if (length == 1) {
            return true;
        }
        int i = 0, j = length - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;

    }

    public static void main(String[] args) {
        int x = 121;
        IsPalindrome_9 isPalindrome9 = new IsPalindrome_9();
        System.out.println(isPalindrome9.isPalindrome(x));
        x = -121;
        System.out.println(isPalindrome9.isPalindrome(x));
        x = 10;
        System.out.println(isPalindrome9.isPalindrome(x));
    }
}
