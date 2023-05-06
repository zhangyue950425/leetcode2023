package offer;

import java.util.Arrays;

public class Exchange {

    public int[] exchange(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        if (length == 0) {
            return result;
        }
        int i = 0, j = length - 1;
        while (i < j) {
            if (nums[i] % 2 != 0 && nums[j] % 2 == 0) {
                i++;
                j--;
                continue;
            }
            if (nums[i] % 2 != 0 && nums[j] % 2 != 0) {
                i++;
                continue;
            }
            if (nums[i] % 2 == 0 && nums[j] % 2 == 0) {
                j--;
                continue;
            }
            if (nums[i] % 2 == 0 && nums[j] % 2 != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        Exchange exchange = new Exchange();
        System.out.println(Arrays.toString(exchange.exchange(nums)));
    }
}
