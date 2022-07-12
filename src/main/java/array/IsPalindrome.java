package array;

/**
 * 125
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (!(chars[left] >= 'a' && chars[left] <= 'z') && !(chars[left] >= '0' && chars[left] <= '9')) {
                left++;
                continue;
            }

            if (!(chars[right] >= 'a' && chars[right] <= 'z') && !(chars[right] >= '0' && chars[right] <= '9')) {
                right--;
                continue;
            }

            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        // "A man, a plan, a canal: Panama"
        String s = "A man, a plan, a canal: Panama";
        IsPalindrome isPalindrome = new IsPalindrome();
        /*System.out.println(isPalindrome.isPalindrome(s));
        s = "race a car";
        System.out.println(isPalindrome.isPalindrome(s));*/
        s = "0P";
        System.out.println(isPalindrome.isPalindrome(s));
    }
}
