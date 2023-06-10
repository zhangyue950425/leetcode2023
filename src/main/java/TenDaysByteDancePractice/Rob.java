package TenDaysByteDancePractice;

import java.util.*;

public class Rob {

    /**
     * 暴力法
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int length = nums.length;
        Map<Integer, List<Integer>> edges = new HashMap<>();
        Set<Integer> all = new HashSet<>();
        for (int i = 0; i < length; i++) {
            List<Integer> list = new ArrayList<>();
            all.add(i);
            edges.put(i, list);
            // 相邻边的节点索引值
            // 下一个
            list.add((i + 1) % length);
            // 前一个
            if (i == 0) {
                list.add(length - 1);
            } else {
                list.add((i - 1) % length);
            }
        }
        int[] max = new int[length];
        for (int i = 0; i < length; i++) {
            Set<Integer> set = new HashSet<>(edges.get(i));
            Set<Integer> allSet = new HashSet<>(all);
            allSet.removeAll(set);
            allSet.remove(i);
            max[i] = nums[i];
            for (Integer num : allSet) {
                max[i] = Math.max(max[i], nums[num] + nums[i]);
            }
        }
        int maxNum = max[0];
        for (int i = 1; i < length; i++) {
            maxNum = Math.max(maxNum, max[i]);
        }
        return maxNum;

    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        return Math.max(maxValue(Arrays.copyOfRange(nums, 0, length - 1)),
                maxValue(Arrays.copyOfRange(nums, 1, length)));
    }

    private int maxValue(int[] nums) {
        int length = nums.length;
        // dp[i]表示前i间房子抢到的最大价值，求从第0间房子到第n-1间房子最大价值，求第1间房子到第n间房子的最大价值，二者的最大值
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < length; i++) {
            // 第i + 1间房子抢或者不抢中取最大
            dp[i + 1] = Math.max(dp[i - 1] + nums[i], dp[i]);
        }
        return dp[length];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 1};
        Rob rob = new Rob();
        //System.out.println(rob.rob(nums));
        System.out.println(rob.rob2(nums));
        nums = new int[] {2, 3, 2};
        //System.out.println(rob.rob(nums));
        System.out.println(rob.rob2(nums));
        nums = new int[] {1, 2, 3};
        //System.out.println(rob.rob(nums));
        System.out.println(rob.rob2(nums));
        nums = new int[] {200,3,140,20,10};
        //System.out.println(rob.rob(nums));
        System.out.println(rob.rob2(nums));
    }
}
