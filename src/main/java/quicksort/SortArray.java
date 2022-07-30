package quicksort;

import java.util.Arrays;

public class SortArray {
    public int[] sortArray(int[] nums) {
        Quick.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        // nums = [5,2,3,1]
        // nums = [5,1,1,2,0,0]
        SortArray sortArray = new SortArray();
        int[] nums = new int[]{5,2,3,1};
        System.out.println(Arrays.toString(sortArray.sortArray(nums)));
        nums = new int[]{5,1,1,2,0,0};
        System.out.println(Arrays.toString(sortArray.sortArray(nums)));
    }
}
