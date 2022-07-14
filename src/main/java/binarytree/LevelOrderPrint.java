package binarytree;

public class LevelOrderPrint {
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

    public void traverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        System.out.printf("节点 %s 在第 %d 层", root.val, level);
        System.out.println();
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
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
        LevelOrderPrint levelOrderPrint = new LevelOrderPrint();
        levelOrderPrint.traverse(root, 1);

    }

}
