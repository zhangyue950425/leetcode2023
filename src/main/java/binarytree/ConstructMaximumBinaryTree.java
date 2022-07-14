package binarytree;

/**
 * 654
 */
public class ConstructMaximumBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int index = -1, maxVal = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if (maxVal < nums[i]) {
                maxVal = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        TreeNode leftNode = buildTree(nums, left, index - 1);
        TreeNode rightNode = buildTree(nums, index + 1, right);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
