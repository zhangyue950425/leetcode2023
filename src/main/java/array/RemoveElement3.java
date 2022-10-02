package array;

public class RemoveElement3 {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int i = 0;
        for (int j = 0;j < length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
