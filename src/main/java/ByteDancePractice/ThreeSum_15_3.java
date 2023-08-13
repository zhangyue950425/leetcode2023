package ByteDancePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15_3 {

    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int num1 = nums[i];
            int j = i + 1;
            int k = length - 1;
            while (j < k) {
                int sum = num1 + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(num1);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    while (j < k && nums[++j] == nums[j - 1]);
                    while (j < k && nums[--k] == nums[k + 1]);
                } else if (sum > 0) {
                    while (j < k && nums[--k] == nums[k + 1]);
                } else {
                    // sum < 0
                    while (j < k && nums[++j] == nums[j - 1]);
                }

            }

        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum_15_3 threeSum_15_3 = new ThreeSum_15_3();
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        System.out.println(threeSum_15_3.threeSum(nums));
        nums = new int[] {0,1,1};
        System.out.println(threeSum_15_3.threeSum(nums));
        nums = new int[] {0,0,0};
        System.out.println(threeSum_15_3.threeSum(nums));
    }
}
