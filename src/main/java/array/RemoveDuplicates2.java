package array;

public class RemoveDuplicates2 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int result = 0;
        int i = 0, j = 1;
        while (i < j && i < length && j < length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                int temp = nums[i + 1];
                nums[i + 1] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
        }
        result = i + 1;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        RemoveDuplicates2 removeDuplicates2 = new RemoveDuplicates2();
        System.out.println(removeDuplicates2.removeDuplicates(nums));
        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates2.removeDuplicates(nums));
    }
}
