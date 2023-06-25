package ByteDancePractice;

import java.util.*;

public class ThreeSum_15 {

    /**
     * 暴力搜索
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                return result;
            }
            int start = i + 1, end = length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);
                    while (start < end && nums[start] == nums[++start]);
                    while (start < end &&  nums[end] == nums[--end]);
                } else if (sum < 0) {
                    while (start < end && nums[start] == nums[++start]);
                } else {
                    while (start < end &&  nums[end] == nums[--end]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum_15 threeSum15 = new ThreeSum_15();
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        //System.out.println(threeSum15.threeSum(nums));
        System.out.println(threeSum15.threeSum2(nums));
        nums = new int[] {0,1,1};
        //System.out.println(threeSum15.threeSum(nums));
        System.out.println(threeSum15.threeSum2(nums));
        nums = new int[] {0,0,0};
        //System.out.println(threeSum15.threeSum(nums));
        System.out.println(threeSum15.threeSum2(nums));
        nums = new int[] {0,0,0,0};
        //System.out.println(threeSum15.threeSum(nums));
        System.out.println(threeSum15.threeSum2(nums));
        nums = new int[] {-1,0,1,0};
        //System.out.println(threeSum15.threeSum(nums));
        System.out.println(threeSum15.threeSum2(nums));
        nums = new int[] {-2,0,1,1,2};
        System.out.println(threeSum15.threeSum2(nums));
    }

}
