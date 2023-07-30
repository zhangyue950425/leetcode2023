package ByteDancePractice;

public class Search_33_2 {

    public int search(int[] nums, int target) {
        int length = nums.length;
        // 旋转点
        int j = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] < nums[i - 1]) {
                j = i;
                break;
            }
        }
        int i = 0;
        if (nums[j] == target) {
            return j;
        }
        if (nums[i] == target) {
            return i;
        }
        if (nums[j] < target) {
            int left = j, right = length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    // nums[mid] < target
                    left = mid + 1;
                }
            }
        }
        if (nums[i] < target) {
            int left = i, right = j - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    // nums[mid] < target
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search_33_2 search332 = new Search_33_2();
        int[] nums = new int[] {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search332.search(nums, target));
        nums = new int[] {4,5,6,7,0,1,2};
        target = 3;
        System.out.println(search332.search(nums, target));
        nums = new int[] {1};
        target = 0;
        System.out.println(search332.search(nums, target));
        nums = new int[] {1,3};
        target = 3;
        System.out.println(search332.search(nums, target));
        nums = new int[] {3, 5, 1};
        target = 5;
        System.out.println(search332.search(nums, target));
    }
}
