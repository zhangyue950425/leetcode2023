package ByteDancePractice;

import java.util.HashMap;
import java.util.Map;

public class Search_33 {

    public int search(int[] nums, int target) {
        int length = nums.length;
        int index = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] < nums[i - 1]) {
                index = i;
                break;
            }
        }
        int[] oriNums = new int[length];
        int n = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (index < length) {
            map.put(nums[index], index);
            oriNums[n++] = nums[index++];
        }
        for (int i = 0; i < index && n < length; i++) {
            map.put(nums[i], i);
            oriNums[n++] = nums[i];
        }
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (oriNums[mid] == target) {
                return map.get(oriNums[mid]);
            } else if (oriNums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分法
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        // 找到旋转点
        int index = length - 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] < nums[i - 1]) {
                index = i;
                break;
            }
        }
        int left = 0;
        int right = length - 1;
        if (target >= nums[0]) {
            left = 0;
            right = index;
        } else {
            left = index;
            right = length - 1;
        }
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        Search_33 search33 = new Search_33();
        int[] nums = new int[] {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search33.search(nums, target));
        System.out.println(search33.search2(nums, target));
        nums = new int[] {4,5,6,7,0,1,2};
        target = 3;
        System.out.println(search33.search(nums, target));
        System.out.println(search33.search2(nums, target));
        nums = new int[] {1};
        target = 0;
        System.out.println(search33.search(nums, target));
        System.out.println(search33.search2(nums, target));
        nums = new int[]{1,3};
        target = 3;
        System.out.println(search33.search(nums, target));
        System.out.println(search33.search2(nums, target));
        nums = new int[]{1,3};
        target = 0;
        System.out.println(search33.search(nums, target));
        System.out.println(search33.search2(nums, target));
    }
}
