package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermuteUnique {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> trace = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrace(nums);
        return result;
    }

    private void backtrace(int[] nums) {
        if (trace.size() == nums.length) {
            result.add(new LinkedList<>(trace));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝，固定相同的元素在排列中的相同位置
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            trace.addLast(nums[i]);
            used[i] = true;
            backtrace(nums);
            trace.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        PermuteUnique permuteUnique = new PermuteUnique();
        /*System.out.println(permuteUnique.permuteUnique(nums));
        nums = new int[]{1,1,2};*/
        System.out.println(permuteUnique.permuteUnique(nums));
    }
}
