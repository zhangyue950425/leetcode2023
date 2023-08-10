package easy;

public class LongestCommonPrefix_14 {

    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 1) {
            return strs[0];
        }
        String result = strs[0];
        for (int i = 1; i < length; i++) {
            String s = strs[i];
            int index = 0;
            int len = Math.min(result.length(), s.length());
            while (index < len && result.charAt(index) == s.charAt(index)) {
                index++;
            }
            if (index == 0) {
                return "";
            }
            result = result.substring(0, index);
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
