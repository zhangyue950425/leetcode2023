package ByteDancePractice;

public class Search_33_3 {

    public int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search_33_3 search_33_3 = new Search_33_3();
        int[] nums = new int[] {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search_33_3.search(nums, target));
        target = 3;
        System.out.println(search_33_3.search(nums, target));
    }
}
