package Hot100;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {

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
     * 用于保存节点值和对应在中序位置的map
     */
  static Map<Integer, Integer> map = new HashMap<>();
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd) {
        if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
            return null;
        }
        // 前序的第一个节点一定是根节点
        int rootVal = preorder[preorderStart];
        int index = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, preorderStart + 1, preorderStart + index - inorderStart, inorder, inorderStart, index - 1);
        root.right = build(preorder, preorderStart + index - inorderStart + 1, preorderEnd, inorder, index + 1, inorderEnd);
        return root;
    }

    /**
     * 中序和后序构造二叉树
     * @param inorder
     * @param postorder
     * @return
     */
    /**
     * 保存中序下节点值和位置索引的对应关系
     */
    static Map<Integer, Integer> inorderMap = new HashMap<>();
    public static TreeNode buildTreeBack(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeBack(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static TreeNode buildTreeBack(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postStart, int postEnd) {
        if (inorderStart > inorderEnd || postStart > postEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int index = inorderMap.get(rootVal);
        root.left = buildTreeBack(inorder, inorderStart, index - 1, postorder, postStart, postStart + index - inorderStart - 1);
        root.right = buildTreeBack(inorder, index + 1, inorderEnd, postorder, postStart + index - inorderStart, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {
        // 前序
        int[] preorder = new int[]{3,9,20,15,7};
        // 中序
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode treeNode = BuildTree.buildTree(preorder, inorder);
        System.out.println(treeNode.val);
        System.out.println(treeNode.left.val);
        System.out.println(treeNode.right.val);
        int[] postorder = new int[] {9,15,7,20,3};
        treeNode = BuildTree.buildTreeBack(inorder, postorder);
        System.out.println(treeNode.val);
        System.out.println(treeNode.left.val);
        System.out.println(treeNode.right.val);
    }
}
