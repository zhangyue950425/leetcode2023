package TenDaysByteDancePractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 41. 缺失的第一个正数:
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 1 <= nums.length <= 5 * 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 */
public class FirstMissingPositive {

    /**
     * 暴力法，不对
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int max = (int) (Math.pow(2.0, 31.0) - 1);
        for (int i = 1; i <= max; i++) {
            int count = 0;
            for (int j = 0; j < length; j++) {
                if (i == nums[j]) {
                    break;
                }
                if (i > nums[j]) {
                    count++;
                }
            }
            if (count == length) {
                return i;
            }
        }
        return 1;
    }

    /**
     * 哈希集合
     * @param nums
     * @return
     */
    public int firstMissingPositive2(int[] nums) {
       int length = nums.length;
       Set<Integer> set = new HashSet<>();
       for (int i = 0; i < length; i++) {
           set.add(nums[i]);
       }
       for (int i = 1; i <= length; i++) {
           if (!set.contains(i)) {
               return i;
           }
       }
       // 如果是走到这里，说明数组中是1到length连续的数
       return length + 1;
    }

    /**
     * 排序+二分查找
     * @param nums
     * @return
     */
    public int firstMissingPositive3(int[] nums) {
        int length = nums.length;
        // 时间复杂度：nlogn
        Arrays.sort(nums);
        // 从1开始在数组中进行二分查找，找不到就是最小的数，找不到返回特殊值如-1
        for (int i = 1; i <= length; i++) {
            if (binarySearch(nums, i) == -1) {
                return i;
            }
        }
        return length + 1;
    }

    /**
     * 原地哈希
     * @param nums
     * @return
     */
    public int firstMissingPositive4(int[] nums) {
        int length = nums.length;
        // 将nums[i]放置到nums[i]-1的索引位置
        for (int i = 0; i < length; i++) {
            //
            while (nums[i] > 0 && nums[i] <= length && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return length + 1;
    }


    private int binarySearch(int[] nums, int num) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == num) {
                return mid;
            } else if (nums[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        // 输入：nums = [1,2,0]
        // 输出：3
        // 输入：nums = [3,4,-1,1]
        // 输出：2
        // 输入：nums = [7,8,9,11,12]
        // 输出：1
        int[] nums = new int[]{1,2,0};
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        //System.out.println(firstMissingPositive.firstMissingPositive(nums));
        System.out.println(firstMissingPositive.firstMissingPositive2(nums));
        System.out.println(firstMissingPositive.firstMissingPositive3(nums));
        System.out.println(firstMissingPositive.firstMissingPositive4(nums));
        nums = new int[]{3,4,-1,1};
        //System.out.println(firstMissingPositive.firstMissingPositive(nums));
        System.out.println(firstMissingPositive.firstMissingPositive2(nums));
        System.out.println(firstMissingPositive.firstMissingPositive3(nums));
        System.out.println(firstMissingPositive.firstMissingPositive4(nums));
        nums = new int[]{7,8,9,11,12};
        //System.out.println(firstMissingPositive.firstMissingPositive(nums));
        System.out.println(firstMissingPositive.firstMissingPositive2(nums));
        System.out.println(firstMissingPositive.firstMissingPositive3(nums));
        System.out.println(firstMissingPositive.firstMissingPositive4(nums));
    }
}
