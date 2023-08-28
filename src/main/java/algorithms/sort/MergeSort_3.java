package algorithms.sort;

import java.util.Arrays;

public class MergeSort_3 {

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        // 拆分
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        // 合并
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] tmp = Arrays.copyOfRange(nums, left , right + 1);
        // 左子数组
        int leftStart = left - left;
        int leftEnd = mid - left;
        // 右子数组
        int rightStart = mid + 1 - left;
        int rightEnd = right - left;
        int i = leftStart;
        int j = rightStart;
        for (int k = left; k <= right; k++) {
            if (i > leftEnd) {
                nums[k] = tmp[j++];
            } else if (j > rightEnd || tmp[i] <= tmp[j]) {
                nums[k] = tmp[i++];
            } else {
                nums[k] = tmp[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1, 5, 3, 4, 0};
        MergeSort_3 mergeSort_3 = new MergeSort_3();
        //System.out.println(Arrays.toString(nums));
        long start = System.currentTimeMillis();
        mergeSort_3.mergeSort(nums, 0, nums.length - 1);
        //System.out.println(Arrays.toString(nums));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
