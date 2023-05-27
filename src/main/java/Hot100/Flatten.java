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
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        flatten(root);
    }

}
