package TenDaysByteDancePractice;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

    /**
     * 前缀和+哈希
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        // 存放前缀和和对应前缀和的个数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        // 用来遍历计算前缀和
        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum = preSum + num;
            if (map.containsKey(preSum - k)) {
                count = count + map.getOrDefault(preSum - k, 0);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }


    /**
     * 暴力方法：遍历
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int length = nums.length;
        int count = 0;
        for (int start = 0; start < length; start++) {
            int sum = 0;
            for (int end = start; end < length; end++) {
                sum = sum + nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 1};
        int k = 2;
        SubarraySum subarraySum = new SubarraySum();
        System.out.println(subarraySum.subarraySum(nums, k));
        System.out.println(subarraySum.subarraySum2(nums, k));
    }
}
