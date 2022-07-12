package leetcodeHot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhangyue
 * @date 2022/4/14
 * 二叉树的中序遍历:
 * 给定一个二叉树的根节点 root ，返回它的中序遍历 。
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 **/
public class inorderTraversal {


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

    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> queue = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty() || root != null) {
            if (root != null) {
                queue.add(root);
                root = root.left;
            } else {
                TreeNode node = queue.pop();
                list.add(node.val);
                root = node.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = null;
        TreeNode rootRight = new TreeNode(2);
        root.left = rootLeft;
        root.right = rootRight;
        TreeNode rightLeft = new TreeNode(3);
        rootRight.left = rightLeft;
        System.out.println(inorderTraversal(root));
    }
}
