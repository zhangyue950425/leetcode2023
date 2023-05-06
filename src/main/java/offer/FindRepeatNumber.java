package offer;

import java.util.Arrays;

public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        if (nums[0] == nums[1]) {
            return nums[0];
        }
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 3, 1, 0, 2, 5, 3};
        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();
        System.out.println(findRepeatNumber.findRepeatNumber(nums));
    }
}
