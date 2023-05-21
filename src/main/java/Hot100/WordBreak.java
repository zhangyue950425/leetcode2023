package Hot100;
import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    /**
     * 动态规划
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i]表示字符串s前i位是否可以拆分表示
        boolean[] dp = new boolean[s.length() + 1];
        // 初始化，为了后面好计算
        dp[0] = true;
        int length = s.length();
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak(s, wordDict));
        s = "applepenapple";
        wordDict.clear();
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(wordBreak.wordBreak(s, wordDict));
        s = "catsandog";
        wordDict.clear();
        // "cats", "dog", "sand", "and", "cat"
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        System.out.println(wordBreak.wordBreak(s, wordDict));
    }
}
