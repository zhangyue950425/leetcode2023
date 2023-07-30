package ByteDancePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15_2 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {
            int num1 = nums[i];
            if (num1 > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = length - 1;
            while (left < right) {
                int num2 = nums[left];
                int num3 = nums[right];
                int sum = num1 + num2 + num3;
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(num1);
                    list.add(num2);
                    list.add(num3);
                    result.add(list);
                    while (left < right && nums[left] == nums[++left]);
                    while (left < right && nums[right] == nums[--right]);
                } else if (sum > 0) {
                    while (left < right && nums[right] == nums[--right]);
                } else {
                    // sum < 0
                    while (left < right && nums[left] == nums[++left]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum_15_2 threeSum152 = new ThreeSum_15_2();
        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum152.threeSum(nums));
        nums = new int[] {0, 0, 0, 0};
        System.out.println(threeSum152.threeSum(nums));
    }
}
