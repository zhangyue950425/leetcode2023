package leetcodeHot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            int num1 = nums[i];
            if (num1 > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = length - 1;
            while (j < k) {
                int num2 = nums[j];
                int num3 = nums[k];
                int sum = num2 + num3 + num1;
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(num1);
                    list.add(num2);
                    list.add(num3);
                    result.add(list);
                    while (j < k && nums[j] == nums[++j]);
                    while (j < k && nums[k] == nums[--k]);
                } else if (sum < 0){
                    while (j < k && nums[j] == nums[++j]);
                } else {
                    while (j < k && nums[k] == nums[--k]);
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum_15 threeSum15 = new ThreeSum_15();
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        System.out.println(threeSum15.threeSum(nums));
        nums = new int[] {0,1,1};
        System.out.println(threeSum15.threeSum(nums));
        nums = new int[] {0,0,0};
        System.out.println(threeSum15.threeSum(nums));
        nums = new int[] {1,-1,-1,0};
        System.out.println(threeSum15.threeSum(nums));
    }
}
