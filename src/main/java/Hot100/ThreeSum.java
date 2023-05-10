package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int one = nums[i];
            int target = -one;
            twoSum(nums, i + 1, length, target, one, result);
        }
        return result;
    }

    private void twoSum(int[] nums, int start, int end, int target, int one, List<List<Integer>> result) {
        for (int i = start; i < end; i++) {
            int two = nums[i];
            for (int j = i + 1; j < end; j++) {
                int three = nums[j];
                if (two + three == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(one);
                    list.add(two);
                    list.add(three);
                    result.add(list);
                }
            }
        }
    }

    /**
     * 排序+双指针
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            // 去掉重复
            if (k > 0 && nums[k - 1] == nums[k]) {
                continue;
            }
            int start = k + 1;
            int end = length - 1;
            while (start < end) {
                int target = nums[k] + nums[start] + nums[end];
                if (target == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[k]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);
                    while (start < end && nums[start] == nums[++start]);
                    while (start < end && nums[end] == nums[--end]);
                } else if (target > 0) {
                    while (start < end && nums[end] == nums[--end]);
                } else {
                    while (start < end && nums[start] == nums[++start]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // nums = [-1,0,1,2,-1,-4]
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        ThreeSum threeSum = new ThreeSum();
        //System.out.println(threeSum.threeSum(nums));
        //System.out.println(threeSum.threeSum2(nums));
        nums = new int[]{-2,0,0,2,2};
        System.out.println(threeSum.threeSum2(nums));
    }
}
