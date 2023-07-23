package ByteDancePractice;

public class Search_704 {

    public int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // nums[mid] > target
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search_704 search704 = new Search_704();
        int[] nums = new int[] {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search704.search(nums, target));
        target = 2;
        System.out.println(search704.search(nums, target));
    }
}
