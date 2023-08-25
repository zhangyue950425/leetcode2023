package ByteDancePractice;

public class FirstMissingPositive_41 {

    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] > 0 && nums[i] <= length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < length; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }
        return length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        FirstMissingPositive_41 firstMissingPositive_41 = new FirstMissingPositive_41();
        int[] nums = new int[] {1, 2, 0};
        System.out.println(firstMissingPositive_41.firstMissingPositive(nums));
        nums = new int[] {3,4,-1,1};
        System.out.println(firstMissingPositive_41.firstMissingPositive(nums));
        nums = new int[] {7,8,9,11,12};
        System.out.println(firstMissingPositive_41.firstMissingPositive(nums));
    }
}
