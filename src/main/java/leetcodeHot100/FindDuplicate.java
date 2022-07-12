package leetcodeHot100;


import java.util.Arrays;

/**
 * 287. 寻找重复数
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        int result = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] == nums[i - 1]) {
                result = nums[i];
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2, 2};
        FindDuplicate findDuplicate = new FindDuplicate();
        System.out.println(findDuplicate.findDuplicate(nums));
    }
}
