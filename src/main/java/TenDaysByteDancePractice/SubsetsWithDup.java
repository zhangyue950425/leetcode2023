package TenDaysByteDancePractice;

import java.util.*;

public class SubsetsWithDup {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, new LinkedList<>(), 0);
        return result;
    }

    private void dfs(int[] nums, LinkedList<Integer> list, int index) {
        result.add(new LinkedList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.addLast(nums[i]);
            dfs(nums, list, i + 1);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,1,2};
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        System.out.println(subsetsWithDup.subsetsWithDup(nums));
    }
}
