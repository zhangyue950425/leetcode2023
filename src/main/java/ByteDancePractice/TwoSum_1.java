package ByteDancePractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {

    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(nums[i], i);
        }
        int[] result = new int[2];
        for (int i = 0; i < length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num) && !map.get(num).equals(i)) {
                result[0] = i;
                result[1] = map.get(num);
            }
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[]{i, map.get(num)};
            }
            map.put(nums[i], i);
        }
        return new int[1];
    }

    public static void main(String[] args) {
        // 输入：nums = [2,7,11,15], target = 9
        // 输出：[0,1]
        // 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
        int[] nums = new int[] {2,7,11,15};
        int target = 9;
        TwoSum_1 twoSum1 = new TwoSum_1();
        //System.out.println(Arrays.toString(twoSum1.twoSum(nums, target)));
        System.out.println(Arrays.toString(twoSum1.twoSum2(nums, target)));
        nums = new int[] {3,3};
        target = 6;
        //System.out.println(Arrays.toString(twoSum1.twoSum(nums, target)));
        System.out.println(Arrays.toString(twoSum1.twoSum2(nums, target)));
    }
}
