package algorithms.sort;

import java.util.Arrays;

/**
 * 快速排序：关键是找到切分元素
 */
public class QuickSort {

    public void quickSort(String[] a, int left, int right) {
        if (left >= right) return;
        int j = partition(a, left, right);
        quickSort(a, left, j - 1);
        quickSort(a, j + 1, right);
    }

    public void quickSort(int[] a, int left, int right) {
        if (left >= right) return;
        int j = partition(a, left, right);
        quickSort(a, left, j - 1);
        quickSort(a, j + 1, right);
    }

    private static Integer partition(int[] a, int left, int right) {
        int v = a[left];
        int i = left;
        int j = right + 1;
        while (true) {
            while (v > a[++i]) if (i == right) break;
            while (v < a[--j]) if (j == left) break;
            if (i >= j) break;
            // 交互
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        // 最后交换切片元素
        int tmp = a[left];
        a[left] = a[j];
        a[j] = tmp;
        return j;
    }

    private static Integer partition(String[] a, int left, int right) {
        String v = a[left];
        int i = left;
        int j = right + 1;
        while (true) {
            while (v.compareTo(a[++i]) > 0) if (i == right) break;
            while (v.compareTo(a[--j]) < 0) if (j == left) break;
            if (i >= j) break;
            // 交互
            String tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        // 最后交换切片元素
        String tmp = a[left];
        a[left] = a[j];
        a[j] = tmp;
        return j;
    }

    public static void main(String[] args) {
        String[] a = new String[]{"Q", "U", "I", "C", "K", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        QuickSort quickSort = new QuickSort();
        //quickSort.quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        quickSort.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
