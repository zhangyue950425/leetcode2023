package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> list = threeSum(nums, target - nums[i]);
            for (List<Integer> l : list) {
                l.add(nums[i]);
            }
            result.addAll(list);
        }
        return result;
    }

    private List<List<Integer>> threeSum(int[] nums, int target) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int k = 0; k < length - 2; k++) {
            if (nums[k] > target) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1, j = length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < target) {
                    while (i < j && nums[i] == nums[++i]);
                } else  if (sum > target) {
                    while (i < j && nums[j] == nums[--j]);
                } else {
                    result.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // nums = [1,0,-1,0,-2,2], target = 0
        int[] nums = new int[]{1,0,-1,0,-2,2};
        int target = 0;
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(nums, target));
    }
}
