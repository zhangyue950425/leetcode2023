package array;

import java.util.Arrays;

public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            sum += twoSumSmaller(nums, target - nums[i], i + 1);
        }
        return sum;
    }

    private int twoSumSmaller(int[] nums, int target, int startIndex) {
        int sum = 0;
        int left = startIndex;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                sum += right - left;
                left++;
            } else {
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 1, 3};
        int target = 2;
        ThreeSumSmaller threeSumSmaller = new ThreeSumSmaller();
        System.out.println(threeSumSmaller.threeSumSmaller(nums, target));
    }
}
