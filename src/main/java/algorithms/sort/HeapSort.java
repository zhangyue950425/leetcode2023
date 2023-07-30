package algorithms.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {


    void heapSort(int[] nums) {
        int length = nums.length;
        // 建堆操作：堆化除叶节点以外的其他所有节点
        for (int i = length / 2 - 1; i >= 0; i--) {
            siftDown(nums, length, i);
        }
        for (int i = length - 1; i > 0; i--) {
            swap(nums, i, 0);
            siftDown(nums, i, 0);
        }
    }

    void heapSortIncrease(int[] nums) {
        int length = nums.length;
        // 建堆操作：堆化除叶节点以外的其他所有节点
        for (int i = length / 2 - 1; i >= 0; i--) {
            siftDownMin(nums, length, i);
        }
        for (int i = length - 1; i > 0; i--) {
            swap(nums, i, 0);
            siftDownMin(nums, i, 0);
        }
    }

    private int getK(int[] nums, int k) {
        int length = nums.length;
        // 建堆操作：堆化除叶节点以外的其他所有节点
        for (int i = length / 2 - 1; i >= 0; i--) {
            siftDown(nums, length, i);
        }
        for (int i = length - 1; i >= length - k; i--) {
            swap(nums, i, 0);
            siftDown(nums, i, 0);
            if (i == length - k) {
                return nums[length - k];
            }
        }
        return nums[length - 1];
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] nums = new int[] {9, 8, 7, 6, 7, 6, 2, 1, 4, 3, 6, 2, 5};
        System.out.println("排序之前：" + Arrays.toString(nums));
        //heapSort.heapSort(nums);
        heapSort.heapSortIncrease(nums);
        System.out.println("排序之后：" + Arrays.toString(nums));
        nums = new int[] {3, 2, 1, 5, 6, 4};
        int k = 2;
        //System.out.println(heapSort.getK(nums, k));
        System.out.println("排序之前：" + Arrays.toString(nums));
        //heapSort.heapSort(nums);
        heapSort.heapSortIncrease(nums);
        System.out.println("排序之后：" + Arrays.toString(nums));
    }

    /**
     * 从顶到底堆化
     * @param nums
     * @param length
     * @param i
     */
    private void siftDown(int[] nums, int length, int i) {
        while (true) {
            int left = 2 * i + 1, right = 2 * i + 2;
            int max = i;
            if (left < length && nums[left] > nums[max]) {
                max = left;
            }
            if (right < length && nums[right] > nums[max]) {
                max = right;
            }
            if (max == i) {
                break;
            }
            swap(nums, i, max);
            i = max;
        }
    }

    /**
     * 从顶到底堆化
     * @param nums
     * @param length
     * @param i
     */
    private void siftDownMin(int[] nums, int length, int i) {
        while (true) {
            int left = 2 * i + 1, right = 2 * i + 2;
            int max = i;
            if (left < length && nums[left] < nums[max]) {
                max = left;
            }
            if (right < length && nums[right] < nums[max]) {
                max = right;
            }
            if (max == i) {
                break;
            }
            swap(nums, i, max);
            i = max;
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}
