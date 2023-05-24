package Hot100;

import java.util.Arrays;

public class SortColors {

    public void sortColors(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return;
        }
        // p0和p2指针,保证[0,p0)全为0，[p0,i)全为1，[p2,len-1)全为2
        int p0 = 0;
        int i = 0;
        int p2 = length - 1;
        // 保证i遍历到所有数据
        while (i <= p2) {
            if (nums[i] == 0) {
                // 交换p0和i位置的元素，还要需要移动p0,保证p0之前的数据都是0
                swap(nums, i, p0);
                p0++;
                // 继续看下一元素
                i++;
            } else if (nums[i] == 2) {
                // 交换p2和i位置的元素，还要需要移动p2,保证p2之后的数据都是2
                // i位置不能变，因为从p2位置交换的元素不知道是否可以放在i这个位置
                swap(nums, i, p2);
                p2--;
            } else {
                // nums[i] == 1 不处理，继续遍历后面的元素
                i++;
            }
        }
    }
    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
