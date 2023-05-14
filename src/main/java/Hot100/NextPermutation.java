package Hot100;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return;
        }
        int i = length - 2;
        int j = length - 1;
        int k = length - 1;
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }
        if (i >= 0) {
            while (nums[i] >= nums[k]) {
                k--;
            }
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
        i = j;
        j = length - 1;
        for (; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        // 输入：nums = [1,2,3]
        // 输出：[1,3,2]
        // 输入：nums = [3,2,1]
        // 输出：[1,2,3]
        int[] nums = new int[]{1,2,3};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{3,2,1};
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
