package offer;

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int[] result = new int[2];
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                result[0] = nums[start];
                result[1] = nums[end];
                return result;
            }
            if (sum > target) {
                end--;
            }
            if (sum < target) {
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 2,7,11,15 9
        // 10,26,30,31,47,60 40
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
        nums = new int[]{10,26,30,31,47,60};
        target = 40;
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
    }
}
