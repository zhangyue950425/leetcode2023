package binarytree;

public class CountNodes {
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

    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        System.out.printf("节点 %s 的左子树有 %d 个节点，右子树有 %d 个节点", root.val, leftCount, rightCount);
        System.out.println();
        return leftCount + rightCount + 1;
    }

    public static void main(String[] args) {
        // root = [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left = left;
        root.right = right;
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        right.left = rightLeft;
        right.right = rightRight;
        CountNodes levelOrderPrint = new CountNodes();
        levelOrderPrint.count(root);

    }

}
