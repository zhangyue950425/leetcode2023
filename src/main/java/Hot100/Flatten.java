package Hot100;

import java.util.*;

public class Flatten {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    /**
     * 使用先序遍历
     * @param root
     */
    static LinkedList<TreeNode> linkedList = new LinkedList<>();
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        preorder(root);
        for (int i = 1; i < linkedList.size(); i++) {
            TreeNode prev = linkedList.get(i - 1);
            TreeNode cur = linkedList.get(i);
            prev.left = null;
            prev.right = cur;
        }
    }
    private static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        linkedList.addLast(root);
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * 迭代实现先序遍历
     * @param root
     */
    public static void flatten2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                linkedList.addLast(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;

        }
        for (int i = 1; i < linkedList.size(); i++) {
            TreeNode pre = linkedList.get(i - 1);
            TreeNode cur = linkedList.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right= new TreeNode(4);
        root.right.right = new TreeNode(6);
        /*preorder(root);
        System.out.println(linkedList);*/
        //flatten(root);
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        //flatten(root);
        flatten2(root);
    }

}
