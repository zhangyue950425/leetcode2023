package leetcodeHot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyue
 * @date 2022/4/26
 * 三数之和:
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，
 * 使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * 输入：nums = []
 * 输出：[]
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 **/
public class threeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums.length == 0 || nums.length == 1) {
            return resultList;
        }
        List<Integer> numList = new ArrayList<>();
        List<Integer> compareList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numList.add(nums[i]);
            compareList.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            int v1 = numList.get(i);
            for (int j = i + 1; j < nums.length; j++) {
                int v2 = numList.get(j);
                int v3 = 0 - v1 - v2;
                compareList.remove(Integer.valueOf(v1));
                compareList.remove(Integer.valueOf(v2));
                List<Integer> arrayList = new ArrayList<>();
                if (compareList.contains(v3)) {
                    arrayList.add(v1);
                    arrayList.add(v2);
                    arrayList.add(v3);
                    resultList.add(arrayList);
                }
                compareList.clear();
                compareList.addAll(numList);
            }
        }
        for (int i = 0; i < resultList.size(); i++) {
            List<Integer> list1 = resultList.get(i);
            int v1 = list1.get(0);
            int v2 = list1.get(1);
            int v3 = list1.get(2);
            for (int j = i + 1; j < resultList.size(); ) {
                List<Integer> list2 = resultList.get(j);
                int v4 = list2.get(0);
                int v5 = list2.get(1);
                int v6 = list2.get(2);
                if ((v1 == v4 && v2 == v5 && v3 == v6)
                        || (v1 == v4 && v2 == v6 && v3 == v5)
                        || (v1 == v5 && v2 == v4 && v3 == v6)
                        || (v1 == v5 && v2 == v6 && v3 == v4)
                        || (v1 == v6 && v2 == v4 && v3 == v5)
                        || (v1 == v6 && v2 == v5 && v3 == v4)) {
                    resultList.remove(list2);
                } else {
                    j++;
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        //nums = [-1,0,1,2,-1,-4]
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        //System.out.println(threeSum(nums));
        nums = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        System.out.println(threeSum(nums));
    }
}
