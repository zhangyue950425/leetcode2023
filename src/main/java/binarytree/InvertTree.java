package binarytree;

public class InvertTree {
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

    // 以root为根进行镜像反转，返回反转忽的root节点
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftNew = invertTree(root.left);
        TreeNode rightNew = invertTree(root.right);
        // 交换
        root.left = rightNew;
        root.right = leftNew;
        return root;
    }

    public static void main(String[] args) {
        // root = [4,2,7,1,3,6,9]
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(7);
        root.left = left;
        root.right = right;
        TreeNode leftLeft = new TreeNode(1);
        TreeNode leftRight = new TreeNode(3);
        left.left = leftLeft;
        left.right = leftRight;
        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(9);
        right.left = rightLeft;
        right.right = rightRight;
        InvertTree invertTree = new InvertTree();
        TreeNode node = invertTree.invertTree(root);

        System.out.println(node.val);
        TreeNode left1 = node.left;
        TreeNode right1 = node.right;
        System.out.println(left1.val);
        System.out.println(right1.val);
        TreeNode left11 = left1.left;
        TreeNode right11 = left1.right;
        System.out.println(left11.val);
        System.out.println(right11.val);
        TreeNode left111 = right1.left;
        TreeNode right111 = right1.right;
        System.out.println(left111.val);
        System.out.println(right111.val);


    }

}
