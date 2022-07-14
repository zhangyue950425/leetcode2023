package binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * 106
 */
public class BuildTree2 {
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

    Map<Integer, Integer> indexValMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexValMap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inLeft, int inRight,
                               int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight) {
            return null;
        }
        int index = indexValMap.get(postorder[postRight]);
        TreeNode root = new TreeNode(postorder[postRight]);
        int leftSize = index - inLeft;
        root.left = buildTree(inorder, inLeft, index - 1,
                postorder, postLeft, postLeft + leftSize - 1);
        root.right = buildTree(inorder, index + 1, inRight,
                postorder, postLeft + leftSize, postRight - 1);
        return root;
    }
}
