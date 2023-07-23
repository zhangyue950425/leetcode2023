package algorithms.sort;

import java.util.Arrays;

public class MergeSort2 {

    private static void mergeSort(int[] nums, int left, int right) {
        // 递归终止条件：分组只有一个元素
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        // 分组合并
        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        // 辅助数组,原地复制使用
        int[] tmp = Arrays.copyOfRange(nums, left, right + 1);
        // 计算左右数据起始终止索引位置
        int leftStart = left - left, leftEnd = mid - left, rightStart = mid + 1 - left, rightEnd = right - left;
        int i = leftStart, j = rightStart;
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
        System.out.println("排序前：" + Arrays.toString(nums));
        MergeSort2.mergeSort(nums, 0, nums.length - 1);
        System.out.println("排序后：" + Arrays.toString(nums));
    }
}
