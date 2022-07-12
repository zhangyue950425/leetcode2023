package leetcodeHot100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 */
public class Flatten {

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

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode node = root;
        while (!deque.isEmpty() || node != null) {
            while (node != null) {
                list.add(node);
                deque.push(node);
                node = node.left;
            }
            node = deque.pop();
            node = node.right;
        }
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1);
            TreeNode curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
        System.out.println(root);

    }

    public static void main(String[] args) {
        // root = [1,2,5,3,4,null,6]
        TreeNode right2 = new TreeNode(6, null, null);
        TreeNode right1 = new TreeNode(4, null, null);
        TreeNode left1 = new TreeNode(3, null, null);
        TreeNode right = new TreeNode(5, null, right2);
        TreeNode left = new TreeNode(2, left1, right1);
        TreeNode root = new TreeNode(1, left, right);
        Flatten flatten = new Flatten();
        flatten.flatten(root);
    }
}
