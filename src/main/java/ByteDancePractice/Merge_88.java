package ByteDancePractice;

import java.util.Arrays;

public class Merge_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int index = m + n - 1;
        while (index1 >= 0 && index2 >= 0) {
            int num1 = nums1[index1];
            int num2 = nums2[index2];
            if (num1 > num2) {
                nums1[index] = num1;
                index--;
                index1--;
            } else {
                nums1[index] = num2;
                index--;
                index2--;
            }

        }
        if (index2 >= 0) {
            for (int i = index2; i >= 0 && index >= 0; i--) {
                nums1[index] = nums2[i];
                index--;
            }
        }

    }

    public static void main(String[] args) {
        Merge_88 merge_88 = new Merge_88();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[] {2,5,6};
        int n = 3;
        merge_88.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[]{1};
        m = 1;
        nums2 = new int[] {};
        n = 0;
        merge_88.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[] {0};
        m = 0;
        nums2 = new int[] {1};
        n = 1;
        merge_88.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[] {4,5,6,0,0,0};
        m = 3;
        nums2 = new int[] {1,2,3};
        n = 3;
        merge_88.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[] {4,0,0,0,0,0};
        m = 1;
        nums2 = new int[] {1,2,3,5,6};
        n = 5;
        merge_88.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
