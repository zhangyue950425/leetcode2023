package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 94
 */
public class InorderTraversal {

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

    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    private List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.addAll(inorderTraversal1(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal1(root.right));
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        res.add(root.val);
        traverse(root.right);
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
        InorderTraversal inorderTraversal = new InorderTraversal();
        System.out.println(inorderTraversal.inorderTraversal(root));
        System.out.println(inorderTraversal.inorderTraversal1(root));
    }
}
