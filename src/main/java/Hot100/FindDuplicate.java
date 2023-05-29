package Hot100;

import java.util.Arrays;

public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,4,2,2};
        FindDuplicate findDuplicate = new FindDuplicate();
        System.out.println(findDuplicate.findDuplicate(nums));
        nums = new int[]{3,1,3,4,2};
        System.out.println(findDuplicate.findDuplicate(nums));
    }
}
