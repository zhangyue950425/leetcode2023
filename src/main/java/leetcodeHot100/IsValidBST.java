package leetcodeHot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 */
public class IsValidBST {

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

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            int rootVal = deque.peek().val;
            root = deque.peek();
            if (root.left == null && root.right == null) {
                deque.pop();
            } else if (root.left != null && root.right != null) {
                int leftVal = root.left.val;
                int rightVal = root.right.val;
                if (leftVal < rootVal && rightVal > rootVal) {
                    deque.pop();
                } else {
                    return false;
                }
                deque.addLast(root.left);
                deque.addLast(root.right);
            } else if (root.left != null) {
                int leftVal = root.left.val;
                if (leftVal < rootVal) {
                    deque.pop();
                } else {
                    return false;
                }
                deque.addLast(root.left);
            } else {
                int rightVal = root.right.val;
                if (rightVal > rootVal) {
                    deque.pop();
                } else {
                    return false;
                }
                deque.addLast(root.right);
            }
        }
        return true;
    }

    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return false;
        }
        double val = -Double.MAX_VALUE;
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (!deque.isEmpty() || root != null) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            if (root.val <= val) {
                return false;
            }
            val = root.val;
            root = root.right;

        }
        return true;

    }

    public static void main(String[] args) {
        // root = [2,1,3]
        /*TreeNode right = new TreeNode(3, null, null);
        TreeNode left = new TreeNode(1, null, null);
        TreeNode root = new TreeNode(2, left, right);
        IsValidBST isValidBST = new IsValidBST();
        System.out.println(isValidBST.isValidBST(root));*/
        // root = [5,1,4,null,null,3,6]
        /*TreeNode right1 = new TreeNode(6, null, null);
        TreeNode left1 = new TreeNode(3, null, null);
        TreeNode right = new TreeNode(4, left1, right1);
        TreeNode left = new TreeNode(1, null, null);
        TreeNode root = new TreeNode(5, left, right);
        IsValidBST isValidBST = new IsValidBST();
        System.out.println(isValidBST.isValidBST(root));*/
        //[5,4,6,null,null,3,7]
        /*TreeNode right1 = new TreeNode(7, null, null);
        TreeNode left1 = new TreeNode(3, null, null);
        TreeNode right = new TreeNode(6, left1, right1);
        TreeNode left = new TreeNode(4, null, null);
        TreeNode root = new TreeNode(5, left, right);
        IsValidBST isValidBST = new IsValidBST();
        System.out.println(isValidBST.isValidBST1(root));*/
        // [-2147483648]
        TreeNode root = new TreeNode(-2147483648, null, null);
        IsValidBST isValidBST = new IsValidBST();
        System.out.println(isValidBST.isValidBST1(root));
    }

}
