package leetcodeHot100;

import java.util.HashMap;

/**
 * 前缀和+哈希表
 */
public class SubarraySum1 {

    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            pre = pre + num;
            if (map.containsKey(pre - k)) {
                result = result + map.get(pre - k);
            }
            if (map.get(pre) != null) {
                map.put(pre, map.get(pre) + 1);
            } else {
                map.put(pre, 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        SubarraySum1 subarraySum = new SubarraySum1();
        //System.out.println(subarraySum.subarraySum(nums, k));
        nums = new int[]{1, 2, 3};
        k = 3;
        //System.out.println(subarraySum.subarraySum(nums, k));
        nums = new int[]{1, -1, 0};
        k = 0;
        System.out.println(subarraySum.subarraySum(nums, k));
    }
}
