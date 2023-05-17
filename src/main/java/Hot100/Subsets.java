package Hot100;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrace(nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrace(int[] nums, int index, ArrayList<Integer> list) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backtrace(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }



    public static void main(String[] args) {
        // nums = [1,2,3]
        int[] nums = new int[]{1,2,3};
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(nums));
    }
}
