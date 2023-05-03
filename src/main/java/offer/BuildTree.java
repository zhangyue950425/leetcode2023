package offer;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      for (int i = 0; i < inorder.length; i++) {
        map.put(inorder[i], i);
      }
      TreeNode treeNode = build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
      return treeNode;
  }
  private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
      if (preStart > preEnd) {
        return null;
      }
      // 先看根节点，是preorder的第一个元素
    int root = preorder[preStart];
      // 找到它在中序的位置，通过map直接拿到，因为不会有元素重复
    int index = map.get(root);
    TreeNode treeNode = new TreeNode(root);
    // 递归看左右子树
    treeNode.left = build(preorder, preStart + 1, index - inStart + preStart, inorder, inStart, index - 1);
    treeNode.right = build(preorder,index - inStart + preStart + 1 , preEnd , inorder, index + 1, inEnd);
    return treeNode;
  }

    public static void main(String[] args) {
      int[] preorder = {3,9,20,15,7};
      preorder = new int[]{1, 2, 5, 4, 6, 7, 3, 8, 9};
      int[] inorder = {9,3,15,20,7};
      inorder = new int[]{5, 2, 6, 4, 7, 1, 8, 3, 9};
      BuildTree buildTree = new BuildTree();
      System.out.println(buildTree.buildTree(preorder, inorder));

    }
}
