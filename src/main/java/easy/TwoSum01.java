package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyue
 */
public class TwoSum01 {

    Map<Integer, Integer> map = new HashMap<>();
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            map.put(nums[i], i);
        }
        int[] result = new int[2];
        for (int i = 0; i < length; i++) {
            int num1 = target - nums[i];
            if (map.containsKey(num1) && i != map.get(num1)) {
                result[0] = i;
                result[1] = map.get(num1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum01 twoSum01 = new TwoSum01();
        int[] nums = new int[] {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum01.twoSum(nums, target)));
        nums = new int[] {3,2,4};
        target = 6;
        System.out.println(Arrays.toString(twoSum01.twoSum(nums, target)));
        nums = new int[] {3,3};
        int target1 = 6;
        System.out.println(Arrays.toString(twoSum01.twoSum(nums, target1)));
    }
}
