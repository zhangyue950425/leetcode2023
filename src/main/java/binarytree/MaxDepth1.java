package binarytree;

/**
 * 104
 */
public class MaxDepth1 {

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

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        // [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left = left;
        root.right = right;
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        right.left = rightLeft;
        right.right = rightRight;
        MaxDepth1 maxDepth = new MaxDepth1();
        System.out.println(maxDepth.maxDepth(root));

    }
}
