package offer;

public class VerifyPostorder {

    public static boolean verifyPostorder(int[] postorder) {
        return post(postorder, 0, postorder.length - 1);
    }

    private static boolean post(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int root = postorder[right];
        int mid = left;
        while (postorder[mid] < root) {
            mid++;
        }
        int temp = mid;
        while (temp < right) {
            if (postorder[temp++] < root) {
                return false;
            }
        }
        return post(postorder, left, mid - 1) && post(postorder, mid, right - 1);
    }

    public static void main(String[] args) {
        // [1,6,3,2,5]
        int[] postorder = new int[]{1,6,3,2,5};
        System.out.println(verifyPostorder(postorder));
        // [1,3,2,6,5]
        postorder = new int[]{1,3,2,6,5};
        System.out.println(verifyPostorder(postorder));
    }
}
