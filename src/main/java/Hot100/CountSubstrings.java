package Hot100;

public class CountSubstrings {

    public int countSubstrings(String s) {
        int length = s.length();
        // 首先初始化为字符串的长度，因为每个单独的字符都可以作为回文
        int count = length;
        char[] chars = s.toCharArray();
        // 判断2到length长度的字符串是不是回文
        for (int i = 2; i <= length; i++) {
            for (int j = 0; j < length && (j + i - 1) < length; j++) {
                int start = j;
                int end = j + i - 1;
                if (check(chars, start, end)) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 判断chars字符数组中从start到end范围内的字符是不是回文
     * @param chars
     * @param start
     * @param end
     * @return
     */
    private boolean check(char[] chars, int start, int end) {
        int left = start;
        int right = end;
        while (left <= right && left >= start && right <= end) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s= "abc";
        CountSubstrings countSubstrings = new CountSubstrings();
        System.out.println(countSubstrings.countSubstrings(s));
        s = "aaa";
        System.out.println(countSubstrings.countSubstrings(s));
        s = "aaaaa";
        System.out.println(countSubstrings.countSubstrings(s));
        s = "fdsklf";
        System.out.println(countSubstrings.countSubstrings(s));
    }
}
