package algorithms.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort2 {

    private static final Random random = new Random(System.currentTimeMillis());

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(nums, left, right);
        quickSort(nums, left, partition - 1);
        quickSort(nums, partition + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pi = left;
        int randIndex = random.nextInt(right - left + 1) + left;
        swap(nums, pi, randIndex);
        int le = left + 1;
        int ge = right;
        while (true) {
            while (le <= ge && nums[le] < nums[pi]) {
                le++;
            }
            while (le <= ge && nums[ge] > nums[pi]) {
                ge--;
            }
            if (le >= ge) {
                break;
            }
            swap(nums, le, ge);
            le++;
            ge--;
        }
        swap(nums, pi, ge);
        return ge;
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        QuickSort2 quickSort2 = new QuickSort2();
        long start = System.currentTimeMillis();
        int[] nums = new int[] {-1, 5, 3, 4, 0};
        //System.out.println("排序前：" + Arrays.toString(nums));
        quickSort2.quickSort(nums, 0, nums.length - 1);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        //System.out.println("排序后：" + Arrays.toString(nums));
    }
}
