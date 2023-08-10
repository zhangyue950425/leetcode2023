package algorithms.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    private void bubbleSort(int[] nums) {
        int length = nums.length;
        for (int i = length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                  swap(nums, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] nums = new int[] {3,2,1,5,6,4};
        System.out.println("排序前：" + Arrays.toString(nums));
        bubbleSort.bubbleSort(nums);
        System.out.println("排序后：" + Arrays.toString(nums));
        nums = new int[] {3,2,3,1,2,4,5,5,6};
        System.out.println("排序前：" + Arrays.toString(nums));
        bubbleSort.bubbleSort(nums);
        System.out.println("排序后：" + Arrays.toString(nums));
    }
}
