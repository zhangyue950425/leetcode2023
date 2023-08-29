package ByteDancePractice;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrace(nums, new ArrayList<>(), 0);
        return result;
    }

    private void backtrace(int[] nums, List<Integer> list, int index) {
        if (index > nums.length) {
            return;
        }
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backtrace(nums, list, i + 1);
            list.remove(list.size() - 1);
        }
     }

    public static void main(String[] args) {
        Subsets_78 subsets_78 = new Subsets_78();
        int[] nums = new int[] {1, 2, 3};
        System.out.println(subsets_78.subsets(nums));
    }
}
