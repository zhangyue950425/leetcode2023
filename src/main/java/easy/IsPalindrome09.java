package easy;

public class IsPalindrome09 {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int num = 0;
        while (x > num) {
            num = num * 10 + x % 10;
            x = x / 10;
        }
        return num == x || x == num / 10;
    }

    public static void main(String[] args) {
        IsPalindrome09 isPalindrome09 = new IsPalindrome09();
        int x = 121;
        System.out.println(isPalindrome09.isPalindrome(x));
        x = -121;
        System.out.println(isPalindrome09.isPalindrome(x));
        x = 10;
        System.out.println(isPalindrome09.isPalindrome(x));
    }
}
