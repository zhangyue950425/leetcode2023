package leetcodeHot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyue
 * @date 2022/4/23
 **/
public class findDisappearedNumbers1 {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == i + 1) {
                i++;
                continue;
            }
            int idx = nums[i] - 1;
            if (nums[i] == nums[idx]) {
                i++;
                continue;
            }
            int temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums));
        nums = new int[]{1, 1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
