package BinarySearch;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length - 1;
        int result = length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                result = mid;
                return result;
            }
            if (nums[mid] > target) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 5;
        SearchInsert searchInsert = new SearchInsert();
        System.out.println(searchInsert.searchInsert(nums, target));
        target = 2;
        System.out.println(searchInsert.searchInsert(nums, target));
        target = 7;
        System.out.println(searchInsert.searchInsert(nums, target));
    }
}
