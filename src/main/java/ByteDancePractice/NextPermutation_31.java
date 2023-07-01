package ByteDancePractice;

import java.util.Arrays;

public class NextPermutation_31 {

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int index1 = length - 2;
        int index2 = length - 1;
        int index3 = length - 1;
        // 先找到一个升序数组对
        while (index1 >= 0 && nums[index1] >= nums[index2]) {
            index1--;
            index2--;
        }
        // 存在升序数组对，再从后开始寻找，寻找到第一个比它小的数
        if (index1 >= 0) {
            while (nums[index3] <= nums[index1]) {
                index3--;
            }
            // 交换
            int tmp = nums[index1];
            nums[index1] = nums[index3];
            nums[index3] = tmp;
        }
        // index2到最后一个元素要保持升序
        reverse(nums, index2, length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        NextPermutation_31 nextPermutation31 = new NextPermutation_31();
        int[] nums = new int[] {1, 2, 3};
        //nextPermutation31.nextPermutation(nums);
        //System.out.println(Arrays.toString(nums));
        nums = new int[] {3, 2, 1};
        //nextPermutation31.nextPermutation(nums);
        //System.out.println(Arrays.toString(nums));
        nums = new int[] {1, 1, 5};
        //nextPermutation31.nextPermutation(nums);
        //System.out.println(Arrays.toString(nums));
        nums = new int[] {1, 2, 3, 8, 5, 7, 6, 4};
        nextPermutation31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
