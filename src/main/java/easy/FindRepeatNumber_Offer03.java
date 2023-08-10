package easy;

public class FindRepeatNumber_Offer03 {

    public int findRepeatNumber(int[] nums) {
        int length = nums.length;
        int i = 0;
        while (i < length) {
            int num1 = nums[i];
            int num2 = nums[num1];
            if (i == num1) {
                i++;
                continue;
            }
            if (num2 == num1) {
                return num1;
            }
            swap(nums, i, num1);
        }
        return -1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        FindRepeatNumber_Offer03 findRepeatNumberOffer03 = new FindRepeatNumber_Offer03();
        int[] nums = new int[] {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumberOffer03.findRepeatNumber(nums));
        nums = new int[] {3,4,2,1,1,0};
        System.out.println(findRepeatNumberOffer03.findRepeatNumber(nums));
    }
}
