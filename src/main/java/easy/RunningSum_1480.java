package easy;

import java.util.Arrays;

public class RunningSum_1480 {

    public int[] runningSum(int[] nums) {
        int length = nums.length;
        int[] sum = new int[length];
        sum[0] = nums[0];
        for (int i = 1; i < length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        RunningSum_1480 runningSum1480 = new RunningSum_1480();
        int[] nums = new int[] {1,2,3,4};
        System.out.println(Arrays.toString(runningSum1480.runningSum(nums)));
        nums = new int[] {1,1,1,1,1};
        System.out.println(Arrays.toString(runningSum1480.runningSum(nums)));
        nums = new int[] {3,1,2,10,1};
        System.out.println(Arrays.toString(runningSum1480.runningSum(nums)));
    }
}
