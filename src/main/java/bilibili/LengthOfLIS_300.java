package bilibili;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LengthOfLIS_300 {

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 1;
        }
        // 最后一个元素石nums[i]的最长上升子序列
        int[] dp = new int[length];
        int maxLen = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    /**
     * 动态规划，输出最大上升序列数组
     * @param nums
     * @return
     */
    public List<Integer> lengthOfLIS2(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            return list;
        }
        int[] dp = new int[length];
        int[] maxIndex = new int[length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < length; i++) {
            maxIndex[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    maxIndex[i] = j;
                }
            }
        }
        int finalMaxIndex = 0;
        for (int i = 0; i < length; i++) {
            finalMaxIndex = dp[i] > dp[finalMaxIndex] ? i : finalMaxIndex;
        }
        List<Integer> list = new ArrayList<>();
        while (finalMaxIndex >= 0) {
            list.add(nums[finalMaxIndex]);
            finalMaxIndex = maxIndex[finalMaxIndex];
        }
        return list;
    }

    public static void main(String[] args) {
        LengthOfLIS_300 lengthOfLIS300 = new LengthOfLIS_300();
        int[] nums = new int[] {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS300.lengthOfLIS(nums));
        System.out.println(lengthOfLIS300.lengthOfLIS2(nums));
        nums = new int[] {0,1,0,3,2,3};
        System.out.println(lengthOfLIS300.lengthOfLIS(nums));
        System.out.println(lengthOfLIS300.lengthOfLIS2(nums));
        nums = new int[] {7,7,7,7,7,7,7};
        System.out.println(lengthOfLIS300.lengthOfLIS(nums));
        System.out.println(lengthOfLIS300.lengthOfLIS2(nums));
    }
}
