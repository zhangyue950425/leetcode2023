package string;

/**
 * 14
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return null;
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < result.length() && j < strs[i].length(); j++) {
                if (result.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            result = result.substring(0, j);
            if (result.equals("")) {
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // strs = ["flower","flow","flight"]
        String[] strs = new String[]{"flower", "flow", "flight"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }
}
