package allleetcode;

import java.util.Arrays;

public class FindMedianSortedArrays04 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] num = new int[m + n];
        for (int i = 0; i < m; i++) {
            num[i] = nums1[i];
        }
        for (int i = 0; i < n; i++) {
            num[i + m] = nums2[i];
        }
        Arrays.sort(num);
        if ((m + n) % 2 == 0) {
            return (num[(m + n) / 2] + num[(m + n) / 2 - 1]) / 2.0;
        } else {
            return num[(m + n) / 2];
        }
    }

    public static void main(String[] args) {
        FindMedianSortedArrays04 findMedianSortedArrays04 = new FindMedianSortedArrays04();
        int[] nums1 = new int[] {1,3};
        int[] nums2 = new int[] {2};
        System.out.println(findMedianSortedArrays04.findMedianSortedArrays(nums1, nums2));
        nums1 = new int[] {1,2};
        nums2 = new int[] {3,4};
        System.out.println(findMedianSortedArrays04.findMedianSortedArrays(nums1, nums2));
    }
}
