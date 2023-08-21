package ByteDancePractice;

import java.util.Arrays;

public class NextPermutation_31_2 {

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int firstIndex = -1;
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstIndex = i;
                break;
            }
        }
        if (firstIndex == -1) {
            reverse(nums, 0, length - 1);
            return;
        }
        int secondIndex = -1;
        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] > nums[firstIndex]) {
                secondIndex = i;
                break;
            }
        }
        swap(nums, firstIndex, secondIndex);
        reverse(nums, firstIndex + 1, length - 1);
    }

    private void reverse(int[] nums, int i , int j) {
        while (i < j) {
           swap(nums, i, j);
           i++;
           j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        NextPermutation_31_2 nextPermutation_31_2 = new NextPermutation_31_2();
        int[] nums = new int[] {1,2,3};
        nextPermutation_31_2.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] {3,2,1};
        nextPermutation_31_2.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] {1,1,5};
        nextPermutation_31_2.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] {1, 2, 7, 4, 3, 1};
        nextPermutation_31_2.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
