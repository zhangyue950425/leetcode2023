package BinarySearch;

/**
 * 704
 */
public class search {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // nums = [-1,0,3,5,9,12], target = 9
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        search search = new search();
        System.out.println(search.search(nums, target));
    }
}
