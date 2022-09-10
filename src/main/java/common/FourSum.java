package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                count++;
            }
        }
        if (count == length && target < 0) {
            return result;
        }
        for (int i = 0; i < length; i++) {
            List<List<Integer>> list = threeSumTarget(nums, i + 1, target - nums[i]);
            for (List<Integer> list1 : list) {
                list1.add(nums[i]);
                result.add(list1);
            }
            while (i < length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return result;
    }


    private List<List<Integer>> threeSumTarget(int[] nums, int start, int target) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i < length; i++) {
            List<List<Integer>> list = twoSumTarget(nums, i + 1, target - nums[i]);
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
        // nums = [1,0,-1,0,-2,2], target = 0
        int[] nums = new int[]{1,0,-1,0,-2,2};
        int target = 0;
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(nums, target));
    }
}
