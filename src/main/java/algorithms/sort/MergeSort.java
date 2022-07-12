package algorithms.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    // 原地归并排序
    private void merge(String[] a, int left, int right, int mid) {
        // 复制一份数组数据，用于比较
        int length = a.length;
        String[] aux = new String[length];
        for (int i = left; i <= right; i++) {
            aux[i] = a[i];
        }
        // 初始化
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                // 左边元素已经遍历完，直接使用右边元素，右边元素继续遍历
                a[k] = aux[j++];
            } else if (j > right) {
                // 右边元素已经遍历完，直接使用左边元素，左边元素继续遍历
                a[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) > 0) {
                // 左边元素大于右边元素，使用右边元素，右边元素继续遍历
                a[k] = aux[j++];
            } else {
                // 右边元素大于等于左边元素，使用左边元素
                a[k] = aux[i++];
            }
        }
    }

    private void merge(int[] a, int left, int right, int mid) {
        // 复制一份数组数据，用于比较
        int length = a.length;
        int[] aux = new int[length];
        for (int i = left; i <= right; i++) {
            aux[i] = a[i];
        }
        // 初始化
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                // 左边元素已经遍历完，直接使用右边元素，右边元素继续遍历
                a[k] = aux[j++];
            } else if (j > right) {
                // 右边元素已经遍历完，直接使用左边元素，左边元素继续遍历
                a[k] = aux[i++];
            } else if (aux[i] > aux[j]) {
                // 左边元素大于右边元素，使用右边元素，右边元素继续遍历
                a[k] = aux[j++];
            } else {
                // 右边元素大于等于左边元素，使用左边元素
                a[k] = aux[i++];
            }
        }
    }

    /**
     * 自顶而下的归并排序：递归
     *
     * @param a
     */
    private void fromTopMergeSort(String[] a) {
        fromTopSort(a, 0, a.length - 1);
    }

    private void fromTopSort(String[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        fromTopSort(a, left, mid);
        fromTopSort(a, mid + 1, right);
        merge(a, left, right, mid);
    }

    public static void main(String[] args) {
        String[] a = new String[]{"E", "E", "G", "M", "R", "A", "C", "E", "R", "T"};
        MergeSort mergeSort = new MergeSort();
        mergeSort.merge(a, 0, a.length - 1, (a.length - 1) / 2);
        System.out.println(Arrays.toString(a));
        a = new String[]{"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        //mergeSort.fromTopMergeSort(a);
        //System.out.println(Arrays.toString(a));
        // 2,0,2,1,1,0
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        mergeSort.merge(nums, 0, nums.length - 1, (nums.length - 1) / 2);
        System.out.println(Arrays.toString(nums));
    }
}
