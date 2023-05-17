package Hot100;

public class Search {

    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 1 && nums[0] == target) {
            return 0;
        }
        if (length == 1 && nums[0] != target) {
            return -1;
        }
        int index = 0;
        for (int i = 0; i < length - 1; i++) {
            int one = nums[i];
            int two = nums[i + 1];
            if (one > two) {
                index = i;
                break;
            }
        }
        // 从0到index升序，index + 1到length也是升序
        int result1 = binarySearch(nums, 0, index, target);
        if (result1 != -1) {
            return result1;
        } else {
            int result2 = binarySearch(nums, index + 1, length - 1, target);
            return result2;
        }


    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        Search search = new Search();
        System.out.println(search.search(nums, target));
        nums = new int[]{4,5,6,7,0,1,2};
        target = 3;
        System.out.println(search.search(nums, target));
        nums = new int[]{1};
        target = 0;
        System.out.println(search.search(nums, target));
        nums = new int[]{1,3};
        target = 0;
        System.out.println(search.search(nums, target));
    }
}
