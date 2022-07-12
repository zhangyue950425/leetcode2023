package leetcodeHot100;

import java.util.HashMap;

/**
 * 494. 目标和
 */
public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) return 0;
        return dp(nums, 0, target);
    }

    // 备忘录
    HashMap<String, Integer> memo = new HashMap<>();

    int dp(int[] nums, int i, int remain) {
        // base case
        if (i == nums.length) {
            if (remain == 0) return 1;
            return 0;
        }
        // 把它俩转成字符串才能作为哈希表的键
        String key = i + "," + remain;
        // 避免重复计算
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // 还是穷举
        int result = dp(nums, i + 1, remain - nums[i]) + dp(nums, i + 1, remain + nums[i]);
        // 记入备忘录
        memo.put(key, result);
        return result;
    }

    int count = 0;

    public int findTargetSumWays1(int[] nums, int target) {
        if (nums.length == 0) return 0;
        backtrace(nums, target, 0, 0);
        return count;
    }

    private void backtrace(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backtrace(nums, target, index + 1, sum + nums[index]);
            backtrace(nums, target, index + 1, sum - nums[index]);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        FindTargetSumWays findTargetSumWays = new FindTargetSumWays();
        //System.out.println(findTargetSumWays.findTargetSumWays(nums, target));
        System.out.println(findTargetSumWays.findTargetSumWays1(nums, target));
    }
}
