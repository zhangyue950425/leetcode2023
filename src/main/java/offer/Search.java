package offer;

public class Search {

    public int search(int[] nums, int target) {
        int length = nums.length;
        int start = 0, end = length - 1;
        int count = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                count++;
                start++;
                end--;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            }
        }
        return count;
    }

    public int search2(int[] nums, int target) {
        int length = nums.length;
        int start = 0, end = length - 1;
        // 搜索右边界
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        int right = start;
        start = 0;
        end = length - 1;
        // 搜索左边界
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                end = mid - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        int left = end;
        return Math.max(right - left - 1, 0);
    }

    public static void main(String[] args) {
        // nums = [5,7,7,8,8,10], target = 8
        // nums = [5,7,7,8,8,10], target = 6
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        Search search = new Search();
        //System.out.println(search.search(nums, target));
        System.out.println(search.search2(nums, target));
        nums = new int[]{5,7,7,8,8,10};
        target = 6;
        //System.out.println(search.search(nums, target));
        System.out.println(search.search2(nums, target));
        nums = new int[]{2,2};
        target = 2;
        //System.out.println(search.search(nums, target));
        System.out.println(search.search2(nums, target));
    }
}
