package ByteDancePractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_1_2 {

    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[] {i, map.get(num)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum_1_2 twoSum_1_2 = new TwoSum_1_2();
        int[] nums = new int[] {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum_1_2.twoSum(nums, target)));
        nums = new int[] {3,2,4};
        target = 6;
        System.out.println(Arrays.toString(twoSum_1_2.twoSum(nums, target)));
        nums = new int[] {3,3};
        target = 6;
        System.out.println(Arrays.toString(twoSum_1_2.twoSum(nums, target)));
    }
}
