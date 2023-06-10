package TenDaysByteDancePractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, new LinkedList<>(), 0);
        return result;
    }

    private void dfs(int[] nums, LinkedList<Integer> list, int index) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.addLast(nums[i]);
            dfs(nums, list, i + 1);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(nums));
    }
}
