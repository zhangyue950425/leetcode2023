package leetcodeHot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集：回溯
 */
public class Subsets1 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrace(nums, path, result, 0);
        return result;
    }

    private void backtrace(int[] nums, List<Integer> path, List<List<Integer>> result, int start) {
        result.add(new ArrayList<>(path));
        //result.add(path);
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrace(nums, path, result, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Subsets1 subsets1 = new Subsets1();
        System.out.println(subsets1.subsets(nums));
    }
}
