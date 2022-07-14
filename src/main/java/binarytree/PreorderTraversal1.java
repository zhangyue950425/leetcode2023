package binarytree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal1 {

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


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        TreeNode leftLeft = new TreeNode(5);
        TreeNode leftRight = new TreeNode(4);
        left.left = leftLeft;
        left.right = leftRight;
        TreeNode rightLeft = new TreeNode(8);
        TreeNode rightRight = new TreeNode(9);
        right.left = rightLeft;
        right.right = rightRight;
        TreeNode rightRightLeft = new TreeNode(6);
        TreeNode rightRightRight = new TreeNode(7);
        leftRight.left = rightRightLeft;
        leftRight.right = rightRightRight;
        PreorderTraversal1 preorderTraversal1 = new PreorderTraversal1();
        System.out.println(preorderTraversal1.preorderTraversal(root));
    }
}
