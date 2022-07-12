package leetcodeHot100;

/**
 * 538. 把二叉搜索树转换为累加树
 */
public class ConvertBST {

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

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum = sum + root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        // [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
        TreeNode right4 = new TreeNode(8, null, null);
        TreeNode right3 = new TreeNode(3, null, null);
        TreeNode right2 = new TreeNode(7, null, right4);
        TreeNode left2 = new TreeNode(5, null, null);
        TreeNode right1 = new TreeNode(2, null, right3);
        TreeNode left1 = new TreeNode(0, null, null);
        TreeNode right = new TreeNode(6, left2, right2);
        TreeNode left = new TreeNode(1, left1, right1);
        TreeNode root = new TreeNode(4, left, right);
        ConvertBST convertBST = new ConvertBST();
        convertBST.convertBST(root);
    }
}
