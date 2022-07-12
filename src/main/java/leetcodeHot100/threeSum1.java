package leetcodeHot100;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyue
 * @date 2022/4/26
 **/
public class threeSum1 implements Serializable {


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums == null || nums.length <= 2) {
            return resultList;
        }
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 2; first++) {
            if (nums[first] > 0) break;
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            int sum = -nums[first];
            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                if (nums[second] + nums[third] == sum) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    resultList.add(list);
                    second++;
                    third--;
                    while (second < third && nums[second] == nums[second - 1]) second++;
                    while (second < third && nums[third] == nums[third + 1]) third--;
                } else if (nums[second] + nums[third] > sum) {
                    third--;
                } else {
                    second++;
                }
            }
        }
        return resultList;

    }

    public static void main(String[] args) {
        //nums = [-1,0,1,2,-1,-4]
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
        nums = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        System.out.println(threeSum(nums));
    }
}
