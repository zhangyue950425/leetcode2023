package BinarySearch;

public class Search2 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // nums = [-1,0,3,5,9,12], target = 9
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 9;
        Search2 search2 = new Search2();
        System.out.println(search2.search(nums, target));
    }
}
