package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 144
 */
public class PreorderTraversal {
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

    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    public static void main(String[] args) {
        // root = [1,null,2,3]
        /*TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.left = null;
        root.right = right;
        TreeNode rightLeft = new TreeNode(3);
        right.left = rightLeft;*/
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
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        System.out.println(preorderTraversal.preorderTraversal(root));
    }
}
