package binarytree;

/**
 * 543
 */
public class DiameterOfBinaryTree {

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

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLength = maxDepth(root.left);
        int rightLength = maxDepth(root.right);
        maxDiameter = Math.max(maxDiameter, leftLength + rightLength);
        return Math.max(leftLength, rightLength) + 1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(5);
        left.left = leftLeft;
        left.right = leftRight;
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(root));
    }
}
