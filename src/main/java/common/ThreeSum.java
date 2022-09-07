package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            List<List<Integer>> list = twoSumTarget(nums, i + 1, -nums[i]);
            for (List<Integer> integerList : list) {
                integerList.add(nums[i]);
                result.add(integerList);
            }
            while (i < length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    private List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        int left = start, right = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        while (left < right) {
            int sum = nums[left] + nums[right];
            int leftVal = nums[left], rightVal = nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                result.add(list);
                while (left < right && nums[left] == leftVal) {
                    left++;
                }
                while (left < right && nums[right] == rightVal) {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // nums = [-1,0,1,2,-1,-4]
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(nums));
    }
}
