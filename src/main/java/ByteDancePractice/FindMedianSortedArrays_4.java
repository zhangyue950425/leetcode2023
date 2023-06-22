package ByteDancePractice;

public class FindMedianSortedArrays_4 {

    /**
     * 暴力解法，O(m+n)时间复杂度
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        int[] result = new int[length];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < length1 && index2 < length2) {
            int num1 = nums1[index1];
            int num2 = nums2[index2];
            if (num1 <= num2) {
                result[index] = num1;
                index1++;
            } else {
                result[index] = num2;
                index2++;
            }
            index++;
        }
        if (index1 < length1) {
            for (int i = index1; i < length1; i++) {
                result[index++] = nums1[i];
            }
        }
        if (index2 < length2) {
            for (int i = index2; i < length2; i++) {
                result[index++] = nums2[i];
            }
        }
        double num;
        index = length / 2;
        // 偶数
        if (length % 2 == 0) {
           num = (double) (result[index] + result[index - 1]) / 2;
        } else {
            num = result[index];
        }
        return num;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays_4 findMedianSortedArrays4 = new FindMedianSortedArrays_4();
        int[] nums1 = new int[] {1,3};
        int[] nums2 = new int[] {2};
        System.out.println(findMedianSortedArrays4.findMedianSortedArrays(nums1, nums2));
        nums1 = new int[] {1,2};
        nums2 = new int[] {3,4};
        System.out.println(findMedianSortedArrays4.findMedianSortedArrays(nums1, nums2));
        nums1 = new int[] {};
        nums2 = new int[] {2,3};
        System.out.println(findMedianSortedArrays4.findMedianSortedArrays(nums1, nums2));
    }
}
