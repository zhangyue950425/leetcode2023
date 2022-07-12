package leetcodeHot100;

/**
 * 105. 从前序与中序遍历序列构造二叉树:
 * 给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历，
 * inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 */
public class BuildTree {

    public class TreeNode {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }
}
