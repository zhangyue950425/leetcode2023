package Hot100;

import java.util.HashMap;
import java.util.Map;

public class FindTargetSumWays {

    public int findTargetSumWays(int[] nums, int target) {
        int length = nums.length;
        if (length == 1 && (nums[0] == target || -nums[0] == target)) {
            return 1;
        }
        return dfs(nums, target, 0, 0);
    }

    /**
     * dfs实现暴力搜索
     * @param nums
     * @param t
     * @param u
     * @param cur
     * @return
     */
    private int dfs(int[] nums, int t, int u, int cur) {
        if (u == nums.length) {
            return cur == t ? 1 : 0;
        }
        int left = dfs(nums, t, u + 1, cur + nums[u]);
        int right = dfs(nums, t, u + 1, cur - nums[u]);
        return left + right;
    }

    /**
     * dfs带有记忆
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays2(int[] nums, int target) {
        return dfsWithCache(nums, target, 0, 0);
    }

    Map<String, Integer> map = new HashMap<>();
    private int dfsWithCache(int[] nums, int t, int u, int cur) {
        String key = u +"_" + cur;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (u == nums.length) {
            map.put(key, cur == t ? 1 : 0);
            return map.get(key);
        }
        int left = dfsWithCache(nums, t, u + 1, cur + nums[u]);
        int right = dfsWithCache(nums, t, u + 1, cur - nums[u]);
        map.put(key, left + right);
        return left + right;
    }

    /**
     * 动态规划
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays3(int[] nums, int target) {
       int length = nums.length;
       int sum = 0;
       for (int i : nums) {
           sum = sum + Math.abs(i);
       }
       if (Math.abs(target) > sum) {
           return 0;
       }
       // dp[i][j]表示前i个数字计算结果为j的方案数量
       int[][] dp = new int[length + 1][2 * sum + 1];
       dp[0][0 + sum] = 1;
       for (int i = 1; i <= length; i++) {
           int num = nums[i - 1];
           for (int j = -sum; j <= sum; j++) {
               if ((j - num) + sum >= 0) {
                   dp[i][j + sum] = dp[i][j + sum] + dp[i - 1][(j - num) + sum];
               }
               if ((j + num) + sum <= 2 * sum) {
                   dp[i][j + sum] = dp[i][j + sum] + dp[i - 1][(j + num) + sum];
               }
           }
       }
       return dp[length][target + sum];
    }

    /**
     * 回溯
     * @param nums
     * @param target
     * @return
     */
    private  int count;
    private  int target;
    private  int[] nums;

    public int findTargetSumWays4(int[] nums, int target) {
        this.target = target;
        this.nums = nums;
        backtrace(0, 0);
        return count;
    }

    private void backtrace(int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backtrace(index + 1, sum + nums[index]);
            backtrace(index + 1, sum - nums[index]);
        }

    }

    /**
     * 二维数组动态规划
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays5(int[] nums, int target) {
        // 所有数字'+'结果
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int negSum = diff / 2;
        int length = nums.length;
        int[][] dp = new int[length + 1][negSum + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j <= negSum; j++) {
                int num = nums[i - 1];
                if (j < num) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];
                }
            }
        }
        return dp[length][negSum];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 1};
        int target = 1;
        FindTargetSumWays findTargetSumWays = new FindTargetSumWays();
        /*System.out.println(findTargetSumWays.findTargetSumWays(nums, target));
        System.out.println(findTargetSumWays.findTargetSumWays2(nums, target));
        System.out.println(findTargetSumWays.findTargetSumWays3(nums, target));*/
        //System.out.println(findTargetSumWays.findTargetSumWays4(nums, target));
        System.out.println(findTargetSumWays.findTargetSumWays5(nums, target));
    }
}
