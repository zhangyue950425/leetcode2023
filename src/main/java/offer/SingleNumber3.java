package offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber3 {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, ++count);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result = entry.getKey();
                break;
            }
        }
        return result;
    }

    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        for (int i = 1; i < length - 1; i++) {
            if (nums[i] != nums[i-1] && nums[i] != nums[i +1]) {
               return nums[i];
            }
        }
        return nums[length - 1];
    }

    public int singleNumber3(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        int result = 0;
        for (int i = 1; i < length - 1; i++) {
            if (nums[i - 1] != nums[i] && nums[i] != nums[i + 1]) {
                result = nums[i];
                break;
            }
        }
        return nums[length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {9,1,7,9,7,9,7};
        SingleNumber3 singleNumber3 = new SingleNumber3();
        System.out.println(singleNumber3.singleNumber(nums));
        nums = new int[]{3,4,3,3};
        System.out.println(singleNumber3.singleNumber2(nums));
        nums = new int[]{5,2,2,2,5,5,4};
        System.out.println(singleNumber3.singleNumber2(nums));
        System.out.println(singleNumber3.singleNumber3(nums));
    }
}
