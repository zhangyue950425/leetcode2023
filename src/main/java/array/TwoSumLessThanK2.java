package array;

import java.util.Arrays;

public class TwoSumLessThanK2 {
    public int twoSumLessThanK(int[] nums, int k) {
        int length = nums.length;
        int max = -1;
        Arrays.sort(nums);
        int left = 0, right = length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < k) {
                max = Math.max(max, nums[left] + nums[right]);
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{34,23,1,24,75,33,54,8};
        int k = 60;
        TwoSumLessThanK2 twoSumLessThanK = new TwoSumLessThanK2();
        System.out.println(twoSumLessThanK.twoSumLessThanK(nums, k));
    }
}
