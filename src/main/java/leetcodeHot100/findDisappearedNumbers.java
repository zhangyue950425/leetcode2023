package leetcodeHot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyue
 * @date 2022/4/23
 * 找到所有数组中消失的数字：
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * <p>
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * <p>
 * 输入：nums = [1,1]
 * 输出：[2]
 **/
public class findDisappearedNumbers {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == nums[j]) {
                    break;
                }
                if (j == nums.length - 1) {
                    result.add(i);
                }
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
