package Hot100;

import java.util.Arrays;

public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        // 以元素nums[i]结尾的数组最长递增子序列长度
        int[] dp = new int[length];
        // 初始化
        Arrays.fill(dp, 1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

        }
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        // 输入：nums = [10,9,2,5,3,7,101,18]
        // 输出：4
        // 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
        // 输入：nums = [0,1,0,3,2,3]
        // 输出：4
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        System.out.println(lengthOfLIS.lengthOfLIS(nums));
        nums = new int[]{0,1,0,3,2,3};
        System.out.println(lengthOfLIS.lengthOfLIS(nums));
        nums = new int[]{7,7,7,7,7,7,7};
        System.out.println(lengthOfLIS.lengthOfLIS(nums));
    }
}
