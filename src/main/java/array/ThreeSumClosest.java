package array;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        int best = 10000000;
        Arrays.sort(nums);
        for (int k = 0; k < length - 2; k++) {
            if (k > 0 &&nums[k] == nums[k - 1]) {
                continue;
            }
            int left = k + 1, right = length - 1;
            while (left < right) {
                int sum = nums[k] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
               if (sum > target) {
                    while (left < right && nums[right] == nums[--right]);
                } else {
                   while (left < right && nums[left] == nums[++left]);
               }
            }
        }
        return best;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        System.out.println(threeSumClosest.threeSumClosest(nums, target));
    }
}
