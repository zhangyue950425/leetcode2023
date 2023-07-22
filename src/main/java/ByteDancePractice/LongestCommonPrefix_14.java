package ByteDancePractice;

public class LongestCommonPrefix_14 {

    /**
     * 比较
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        String result = strs[0];
        for (int i = 1; i < length; i++) {
            int end = 0;
            char[] chars = strs[i].toCharArray();
            char[] resultChars = result.toCharArray();
            int len = Math.min(chars.length, resultChars.length);
            while (end < len) {
                if (chars[end] != resultChars[end]) {
                    break;
                }
                end++;
            }
            result = result.substring(0, end);
            if (result.isEmpty()) {
                return "";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestCommonPrefix_14 longestCommonPrefix14 = new LongestCommonPrefix_14();
        String[] strs = new String[] {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix14.longestCommonPrefix(strs));
        strs = new String[] {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix14.longestCommonPrefix(strs));
    }
}
