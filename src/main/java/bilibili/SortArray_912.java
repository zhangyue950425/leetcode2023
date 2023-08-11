package bilibili;

import java.util.Arrays;
import java.util.Random;

public class SortArray_912 {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pi = partition(nums, left, right);
        quickSort(nums, left, pi - 1);
        quickSort(nums, pi + 1, right);
    }

    private static final Random random = new Random(System.currentTimeMillis());

    private int partition(int[] nums, int left, int right) {
       int rand = random.nextInt(right - left + 1) + left;
       int pi = left;
       swap(nums, pi, rand);
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
        SortArray_912 sortArray912 = new SortArray_912();
        int[] nums = new int[] {5,2,3,1};
        System.out.println(Arrays.toString(sortArray912.sortArray(nums)));
        nums = new int[] {5,1,1,2,0,0};
        System.out.println(Arrays.toString(sortArray912.sortArray(nums)));
    }
}
